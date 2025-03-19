package com.groom.manvsclass.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.groom.manvsclass.util.ServiceURL;
import com.groom.manvsclass.util.filesystem.FileOperationUtil;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

@Service
public class RobotService {
	public static final String VOLUME_T0_BASE_PATH = "/VolumeT0/FolderTree/ClassUT/";
	public static final String UNMODIFIED_SRC = "unmodified_src";
	public static final String BASE_SRC_PATH = "src/main/java";
	public static final String BASE_TEST_PATH = "src/test/java";
	public static final String BASE_COVERAGE_PATH = "coverage";
	private static final String BASE_CODE_PATH = "project";

	private static final String JACOCO_COVERAGE_FILE = "coveragetot.xml";
	private static final String EVOSUITE_COVERAGE_FILE = "statistics.csv";

	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RobotService.class.getName());

	//--------------------------------------------------

	ServiceURL serviceURL;

	public RobotService(ServiceURL serviceURL) {
		this.serviceURL = serviceURL;
	}

	private int[] getJacocoCoverageByCoverageType(String filePath, String coverageType) {
		try {
			Document doc = Jsoup.parse(new File(filePath), "UTF-8", "", Parser.xmlParser());
			// Selezione dell'elemento counter in base al tipo di copertura
			Element counter = doc.selectFirst("report > counter[type=" + coverageType + "]");

			if (counter == null) {
				throw new IllegalArgumentException("Elemento 'counter' di tipo '" + coverageType + "' non trovato nel documento XML.");
			}

			int covered = Integer.parseInt(counter.attr("covered"));
			int missed = Integer.parseInt(counter.attr("missed"));

			// Restituisce i due valori come array: [covered, missed]
			return new int[]{covered, missed};
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Gli attributi 'covered' e 'missed' devono essere numeri interi validi.", e);
		} catch (Exception e) {
			throw new RuntimeException("Errore durante l'elaborazione del documento XML.", e);
		}
	}

	private int[] getEmmaCoverageByCoverageType(String path, String coverageType) {
		try {
			File cov = new File(path);
			Document doc = Jsoup.parse(cov, null, "", Parser.xmlParser());

			// Seleziona solo il primo elemento che corrisponde al tipo di coverage richiesto
			Element stat = doc.selectFirst("coverage[type=\"" + coverageType + "\"]");

			if (stat == null) {
				throw new IllegalArgumentException("Nessuna riga trovata per il tipo di coverage: " + coverageType);
			}

			String value = stat.attr("value");
			Pattern pattern = Pattern.compile("\\((\\d+(?:\\.\\d+)?)/(\\d+(?:\\.\\d+)?)\\)"); //Patter per catturare interi e decimali
			Matcher matcher = pattern.matcher(value);

			if (!matcher.find()) {
				throw new IllegalArgumentException("Formato valore non valido: " + value);
			}

			int covered = (int) Double.parseDouble(matcher.group(1));
			int total = (int) (Double.parseDouble(matcher.group(2)) - Double.parseDouble(matcher.group(1)));

			return new int[]{covered, total};
		} catch (IOException e) {
			throw new RuntimeException("Errore nella lettura del file XML.", e);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Gli attributi 'covered' e 'total' devono essere numeri interi validi.", e);
		} catch (Exception e) {
			throw new RuntimeException("Errore durante l'elaborazione del documento XML.", e);
		}
	}

	private int[] getEvoSuiteCoverageStatistics(String filePath) {
		List<Integer> values = new ArrayList<>();
		String line;
		String delimiter = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			boolean firstLine = true; // salto la prima riga, che contiene i nomi delle colonne

			while ((line = br.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					continue;
				}

				String[] columns = line.split(delimiter);

				// Verifico che esistano almeno 3 colonne, la percentuale di coverage si trova sulla terza
				if (columns.length >= 3) {
					try {
						double value = Double.parseDouble(columns[2].trim()) * 100;
						values.add((int) value);
					} catch (NumberFormatException e) {
						System.err.println("Errore nella conversione a intero: " + e);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Converto la lista in array di interi
		return values.stream().mapToInt(i -> i).toArray();
	}

	private void outputProcess(Process process) throws IOException{
		// Legge l'output del processo esterno tramite un BufferedReader, che a sua
		// volta usa
		// un InputStreamReader per convertire i byte in caratteri. Il metodo
		// 'process.getInputStream()'
		// restituisce lo stream di input del processo esterno.
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

		// All'interno del loop viene letta ogni linea disponibile finché il processo
		// continua a produrre output.
        while ((line = reader.readLine()) != null)
            System.out.println(line);
		
		// funzionamento analogo al precedente, invece di leggere l'output leggiamo gli
		// errori
        reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((line = reader.readLine()) != null)
            System.out.println(line);

        try {
			// Attende che il processo termini e restituisce il codice di uscita
			int exitCode = process.waitFor();

			System.out.println("ERRORE CODE: " + exitCode);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void uploadRobotCoverageInT4(int[] evoSuiteStatistics, int[][] jacocoStatistics, int livello, String className, String robotName, String coverage) throws IOException{
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost("http://" + serviceURL.getT4ServiceURL() + "/robots");

		// Creazione di un array JSON per contenere le informazioni sui robot generati
		JSONArray arr = new JSONArray();

		// Creazione di un oggetto JSON per rappresentare un singolo robot generato
		JSONObject rob = new JSONObject();

		// l'array JSON viene utilizzato per raggruppare gli oggetti JSON che
		// rappresentano le informazioni sui robot generati.
		// L'array arr contiene una serie di oggetti rob, ognuno dei quali rappresenta


		// Aggiunge al robot l'informazione relativa al punteggio convertito in stringa
		rob.put("jacocoLineCovered", jacocoStatistics[0][0]);
		rob.put("jacocoLineMissed", jacocoStatistics[0][1]);
		rob.put("jacocoBranchCovered", jacocoStatistics[1][0]);
		rob.put("jacocoBranchMissed", jacocoStatistics[1][1]);
		rob.put("jacocoInstructionCovered", jacocoStatistics[2][0]);
		rob.put("jacocoInstructionMissed", jacocoStatistics[2][1]);

		rob.put("evoSuiteLine", evoSuiteStatistics[0]);
		rob.put("evoSuiteBranch", evoSuiteStatistics[1]);
		rob.put("evoSuiteException", evoSuiteStatistics[2]);
		rob.put("evoSuiteWeakMutation", evoSuiteStatistics[3]);
		rob.put("evoSuiteOutput", evoSuiteStatistics[4]);
		rob.put("evoSuiteMethod", evoSuiteStatistics[5]);
		rob.put("evoSuiteMethodNoException", evoSuiteStatistics[6]);
		rob.put("evoSuiteCBranch", evoSuiteStatistics[7]);

		rob.put("type", robotName);
		rob.put("difficulty", String.valueOf(livello));
		rob.put("testClassId", className);

		rob.put("coverage", coverage);
		
		// Aggiunge l'oggetto robot all'array JSON
		arr.put(rob);

		// Crea un oggetto JSON principale contenente l'array di robot
		JSONObject obj = new JSONObject();

		// inserimento dell'array di robot all'interno dell'oggetto
		obj.put("robots", arr);

		// Crea un'entità JSON utilizzando il contenuto dell'oggetto JSON principale.
		StringEntity jsonEntity = new StringEntity(obj.toString(), ContentType.APPLICATION_JSON);
		
		// Configura la richiesta POST con l'entità JSON creata
		httpPost.setEntity(jsonEntity);

		// esegue la richiesta ed ottiene la risposta
		HttpResponse response = httpClient.execute(httpPost);
		logger.info("T4 upload robot response: " + EntityUtils.toString(response.getEntity()));
	}

    public void generateAndSaveRobots(String fileName, String className, MultipartFile classFile) throws IOException {

        // RANDOOP - T9			    
		Path directory = Paths.get("/VolumeT9/FolderTree/ClassUT/" + className + "/src/main/java");
		FileOperationUtil.saveFileInFileSystem(fileName, directory, classFile);
		
		//Randoop T9
		// creazione del processo esterno di generazione dei test
        ProcessBuilder processBuilder = new ProcessBuilder();

		// con command si configura il comando del processo esterno per eseguire il file
		// JAR 'Task9-G19-0.0.1-SNAPSHOT.jar'
		// l'esecuzione avviene attraverso la JVM di Java.
		// Il parametro "-jar" specifica l'esecuzione di un file JAR.
        processBuilder.command("java", "-jar", "Task9-G19-0.0.1-SNAPSHOT.jar");

		// La directory di lavoro per il processo esterno viene impostata su
		// "/VolumeT9/" utilizzando
		// questo metodo garantisce che il processo lavori nella directory desiderata
        processBuilder.directory(new File("/VolumeT9/"));
		
		// si avvia il processo
        Process process = processBuilder.start();

		//Legge l'output del processo appena creato
		outputProcess(process);

		File robotCoverageDirBasePath = new File(String.format("%s/%s/%s", VOLUME_T0_BASE_PATH, className, BASE_COVERAGE_PATH));
		String robotName = "Randoop";
		for (File levelFolder : Objects.requireNonNull(robotCoverageDirBasePath.listFiles())) {
			String emmaCoveragePath = String.format("%s/%s", levelFolder, "coveragetot.xml");

			int[] evoSuiteStatistics = getEvoSuiteCoverageStatistics(String.format("%s/%s", levelFolder, "statistics.csv"));
			int[][] emmaStatistics = {
					getEmmaCoverageByCoverageType(emmaCoveragePath, "line, %"),
					getEmmaCoverageByCoverageType(emmaCoveragePath, "method, %"),
					getEmmaCoverageByCoverageType(emmaCoveragePath, "block, %")
			};

			int level = Integer.parseInt(levelFolder.toString().substring(levelFolder.toString().length() - 7, levelFolder.toString().length() - 5));
			String coverage = Files.lines(Paths.get(emmaCoveragePath)).collect(Collectors.joining(System.lineSeparator()));

			uploadRobotCoverageInT4(evoSuiteStatistics, emmaStatistics, level, className, robotName, coverage);

		}


		// Il seguente codice è l'adattamento ad evosuite del codice appena visto, i
		// passaggi sono gli stessi
        // EVOSUITE - T8
		// TODO: RICHIEDE AGGIUSTAMENTI IN T8
		Path directoryE = Paths.get("/VolumeT8/FolderTree/ClassUT/" + className + "/src/main/java");

		FileOperationUtil.saveFileInFileSystem(fileName, directoryE, classFile);

		ProcessBuilder processBuilderE = new ProcessBuilder();

        processBuilderE.command("bash", "robot_generazione.sh", className, "\"\"", "/VolumeT9/FolderTree/ClassUT/" + className + "/src/main/java", String.valueOf("1"));
        processBuilderE.directory(new File("/VolumeT8/Prototipo2.0/"));

		Process processE = processBuilderE.start();

		outputProcess(processE);

		robotCoverageDirBasePath = new File(String.format("%s/%s/%s", VOLUME_T0_BASE_PATH, className, BASE_COVERAGE_PATH));
		robotName = "Evosuite";
		for (File levelFolder : Objects.requireNonNull(robotCoverageDirBasePath.listFiles())) {
			String jacocoCoveragePath = String.format("%s/%s", levelFolder, "coveragetot.xml");

			int[] evoSuiteStatistics = getEvoSuiteCoverageStatistics(String.format("%s/%s", levelFolder, "statistics.csv"));
			int[][] jacocoStatistics = {
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "LINE"),
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "BRANCH"),
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "INSTRUCTION")
			};

			int level = Integer.parseInt(levelFolder.toString().substring(levelFolder.toString().length() - 7, levelFolder.toString().length() - 5));
			String coverage = Files.lines(Paths.get(jacocoCoveragePath)).collect(Collectors.joining(System.lineSeparator()));

			uploadRobotCoverageInT4(evoSuiteStatistics, jacocoStatistics, level, className, robotName, coverage);

		}

    }


	private void generateMissingEvoSuiteCoverage(String classUTName, String classUTPackageName, Path classUTPath, Path testPath, Path toCoveragePath, Path evoSuiteWorkingDir, String testPackageName) throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			logger.info("serviceURL.getT8ServiceURL(): " + serviceURL.getT8ServiceURL());
			HttpPost httpPostT8 = new HttpPost("http://" + serviceURL.getT8ServiceURL() + "/coverage/randoop");


			JSONObject reqBody = new JSONObject();
			reqBody.put("classUTName", classUTName);
			reqBody.put("classUTPath", classUTPath);
			reqBody.put("classUTPackage", classUTPackageName);
			reqBody.put("unitTestPath", testPath);
			reqBody.put("evosuiteWorkingDir", evoSuiteWorkingDir);

			// Imposta il body della richiesta
			StringEntity entity = new StringEntity(reqBody.toString(), ContentType.APPLICATION_JSON);
			httpPostT8.setEntity(entity);

			// Esegue la richiesta HTTP
			try (CloseableHttpResponse response = httpClient.execute(httpPostT8)) {
				JSONObject responseBody = new JSONObject(EntityUtils.toString(response.getEntity()));
				logger.info("responseBody: " + responseBody);
				FileOperationUtil.writeStringToFile(responseBody.get(classUTPackageName).toString(), new File(String.format("%s/%s", toCoveragePath, "statistics.csv")));
			}

			FileOperationUtil.deleteDirectoryRecursively(evoSuiteWorkingDir);
		} catch (IOException e) {
			FileOperationUtil.deleteDirectoryRecursively(evoSuiteWorkingDir);
			e.printStackTrace();
		}
	}

	private void generateMissingJacocoCoverage(Path fromSrcPath, Path fromTestPath, Path toTmpPath, Path toCoveragePath) throws IOException {
		Files.createDirectories(Paths.get(String.format("%s/%s", toTmpPath, Paths.get(BASE_SRC_PATH))));
		FileOperationUtil.copyDirectoryRecursively(fromSrcPath, Paths.get(String.format("%s/%s", toTmpPath, Paths.get(BASE_SRC_PATH))));

		Files.createDirectories(Paths.get(String.format("%s/%s", toTmpPath, Paths.get(BASE_TEST_PATH))));
		FileOperationUtil.copyDirectoryRecursively(fromTestPath, Paths.get(String.format("%s/%s", toTmpPath, Paths.get(BASE_TEST_PATH))));

		File zip = null;
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			FileOperationUtil.zipDirectory(String.format("%s/src", toTmpPath), String.format("%s/src.zip", toTmpPath));
			zip = new File(String.format("%s/src.zip", toTmpPath));

			if (!zip.exists()) {
				System.err.println("Errore: Il file ZIP non è stato creato correttamente.");
				return;
			}

			HttpPost httpPost = new HttpPost("http://" + serviceURL.getT7ServiceURL() + "/coverage/evosuite");

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.STRICT); // Assicura compatibilità
			builder.addBinaryBody("project", zip);

			HttpEntity multipart = builder.build();
			httpPost.setEntity(multipart);
			httpPost.setHeader("Accept", "application/json");

			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
				JSONObject responseBody = new JSONObject(EntityUtils.toString(response.getEntity()));
				FileOperationUtil.writeStringToFile(responseBody.getString("coverage"), new File(String.format("%s/coveragetot.xml", toCoveragePath)));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Files.delete(zip.toPath());
		FileOperationUtil.deleteDirectoryRecursively(toTmpPath);
	}

	private String[] extractTestPackageNameFromCode(String code) {
		Pattern pattern = Pattern.compile("\\bpackage\\s*([a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*)\\s*;", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(code);

		if (matcher.find()) {
			String packageName = matcher.group(1).trim();
			return packageName.split("\\.");
		}

		return null; // Nessun package trovato
	}

	private String[] extractSrcPackageFromCode(String code, String className, String robotType) {
		Pattern pattern; Matcher matcher;

		switch (robotType) {
            case "Evosuite":
				// Costruisce il pattern per cercare il package della classe testata
				String regex = "org\\.evosuite\\.runtime\\.RuntimeSettings\\.className\\s*=\\s*\"([\\w.]+)\\." + className + "\"";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(code);

				if (matcher.find()) {
					String packageName = matcher.group(1); // Estrae solo il package senza la classe
					return packageName.split("\\."); // Divide il package in array di stringhe
				}

				return null; // Nessun package trovato
			case "Randoop":
			default:
				pattern = Pattern.compile("\\bimport\\s+([a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*)\\." + className + "\\s*;");
				matcher = pattern.matcher(code);

				if (matcher.find()) {
					String packageName = matcher.group(1);
					return packageName.split("\\.");
				}

				return null; // Nessun package trovato
        }
	}

	private void modifyAndSaveSrcFile(String fileName, Path directory, MultipartFile originalFile, String edit) throws IOException{
		// Leggi il contenuto come stringa
		String content = new String(originalFile.getBytes());

		// Aggiungi il package all'inizio
		String modifiedContent = "package " + edit + ";\n" + content;

		// Salva il file modificato
		Path filePath = directory.resolve(fileName);
		File outputFile = filePath.toFile();
		try (FileWriter writer = new FileWriter(outputFile)) {
			writer.write(modifiedContent);
		}
	}



	private String[][] saveTestFilesInVolume(Path fromTestPath, Path toTestPath, String className, String robotType) throws IOException {
		String[] testPackageName = null;
		String[] srcPackageName = null;

		for (File src : Objects.requireNonNull(Objects.requireNonNull(fromTestPath.toFile()).listFiles())) {
			if (!src.getName().contains(".java"))
				continue;

			String content = Files.lines(src.toPath()).collect(Collectors.joining(System.lineSeparator()));

			testPackageName = extractTestPackageNameFromCode(content);
			if (srcPackageName == null) {
				srcPackageName = extractSrcPackageFromCode(content, className, robotType);
			}

			String testPackagePath = "";
			if (testPackageName != null) {
				testPackagePath = String.join("/", testPackageName);
			}

			Files.createDirectories(Paths.get(String.format("%s/%s", toTestPath, testPackagePath)).normalize());
			Files.copy(src.toPath(), Paths.get(String.format("%s/%s/%s", toTestPath, testPackagePath, src.getName())).normalize());
		}

		return new String[][]{srcPackageName, testPackageName};
	}

	private void saveSrcFileInVolume(MultipartFile src, Path srcPath, String[] srcPackageName, String srcFileName) throws IOException {
		String srcPackagePath = "";

		if (srcPackageName != null) {
			srcPackagePath = String.join("/", srcPackageName);
			String srcPackageCodeLine = String.join(".", srcPackagePath);
			Files.createDirectories(Paths.get(String.format("%s/%s", srcPath, srcPackagePath)));
			modifyAndSaveSrcFile(srcFileName, Paths.get(String.format("%s/%s", srcPath, srcPackagePath)), src, srcPackageCodeLine);
		} else {
			Files.createDirectories(Paths.get(String.format("%s/%s", srcPath, srcPackagePath)));
			FileOperationUtil.saveFileInFileSystem(srcFileName, Paths.get(String.format("%s/%s", srcPath, srcPackagePath)), src);
		}
	}

	private boolean[] saveCoverageFilesInVolume(Path searchIn, Path coveragePath) throws IOException, NullPointerException {
		boolean jacocoFound = false;
		boolean evosuiteFound = false;

		if (!Files.exists(searchIn)) {
			return new boolean[]{jacocoFound, evosuiteFound};
		}

		for (File coverageFile : Objects.requireNonNull(searchIn.toFile().listFiles())) {
			Files.createDirectories(Paths.get(String.format("%s", coveragePath)));

			if (coverageFile.getName().equals(JACOCO_COVERAGE_FILE)) {
				String coverage = Files.lines(coverageFile.toPath()).collect(Collectors.joining(System.lineSeparator()));
				if (coverage.contains("<coverage type=\"line, %\" value=")) {
					continue;
				}

				Files.copy(coverageFile.toPath(), Paths.get(String.format("%s/%s", coveragePath, coverageFile.getName())));
				jacocoFound = true;
			}

			if (coverageFile.getName().equals(EVOSUITE_COVERAGE_FILE)) {
				Files.copy(coverageFile.toPath(), Paths.get(String.format("%s/%s", coveragePath, coverageFile.getName())));
				evosuiteFound = true;
			}
		}

		return new boolean[]{jacocoFound, evosuiteFound};
	}

	/*
	private boolean checkExtractedFolderStructure(Path extractedFolder) throws IOException {
		File[] robotGroupFolder = extractedFolder.toFile().listFiles();
		if (robotGroupFolder == null)
			throw new IOException("The zipped folder doesn't contain folders");

		File[] robotFolders = robotGroupFolder[0].listFiles();
		if (robotFolders == null)
			throw new IOException("The zipped folder doesn't contain folders");

		File[] acceptedRobotFolders = Arrays.stream(robotFolders).filter(folder -> folder.getName().endsWith("Test") && folder.isDirectory()).toArray(File[]::new);
		if (acceptedRobotFolders.length == 0)
			throw new IOException("The zipped folder doesn't contain robot folders");

		for (File robotFolder : acceptedRobotFolders) {
			File[] levelFolder = robotFolder.listFiles();




			if (!robotFolder.isDirectory()) {
				logger.info("Ignoring file " + robotFolder + " because it is not a directory");
				continue;
			}

			String robotType = robotFolder.getName();
			if (!robotType.endsWith("Test")) {
				logger.info("Ignoring directory " + robotFolder + " because it does not follow the naming convention");
				continue;
			}
			robotType = robotType.substring(0, robotType.length() - 4).toLowerCase();
			robotType = Character.toUpperCase(robotType.charAt(0)) + robotType.substring(1);

			logger.info("Robot folder " + robotFolder);
			logger.info("Saving robot type " + robotType);
			uploadGenericRobot(classUTFileName, classUTName, classUTFile, robotFolder.toPath(), robotType, Paths.get(VOLUME_T0_BASE_PATH));
		}
	}

	 */

	public void saveRobotsFromZip(String classUTFileName, String classUTName, MultipartFile classUTFile, MultipartFile robotTestsZip) throws IOException {
		Path operationTmpFolder = Paths.get(String.format("%s/%s/tmp", VOLUME_T0_BASE_PATH, classUTName));
		FileOperationUtil.saveFileInFileSystem("robot.zip", operationTmpFolder, robotTestsZip);
		FileOperationUtil.extractZipIn(operationTmpFolder);

		Path unmodifiedSrcCodePath = Paths.get(String.format("%s/%s/%s", VOLUME_T0_BASE_PATH, UNMODIFIED_SRC, classUTName));
		logger.info("Saving unmodified src in " + unmodifiedSrcCodePath);
		FileOperationUtil.saveFileInFileSystem(classUTFileName, unmodifiedSrcCodePath, classUTFile);

		File robotGroupFolder = Objects.requireNonNull(operationTmpFolder.toFile().listFiles())[0];
		logger.info("Robot tests folder " + robotGroupFolder);
		for (File robotFolder : Objects.requireNonNull(robotGroupFolder.listFiles())) {
			if (!robotFolder.isDirectory()) {
				logger.info("Ignoring file " + robotFolder + " because it is not a directory");
				continue;
			}

			String robotType = robotFolder.getName();
			if (!robotType.endsWith("Test")) {
				logger.info("Ignoring directory " + robotFolder + " because it does not follow the naming convention");
				continue;
			}
			robotType = robotType.substring(0, robotType.length() - 4).toLowerCase();
			robotType = Character.toUpperCase(robotType.charAt(0)) + robotType.substring(1);

			logger.info("Robot folder " + robotFolder);
			logger.info("Saving robot type " + robotType);
			uploadGenericRobot(classUTFileName, classUTName, classUTFile, robotFolder.toPath(), robotType, Paths.get(VOLUME_T0_BASE_PATH));
		}

		FileOperationUtil.deleteDirectoryRecursively(operationTmpFolder);
	}

	private void uploadGenericRobot(String classUTFileName, String classUTName, MultipartFile classUTFile, Path operationTmpFolder, String robotType, Path volumeBasePath) throws IOException {
		for (File levelFolder : Objects.requireNonNull(operationTmpFolder.toFile().listFiles())) {
			if (!levelFolder.isDirectory()) {
				logger.info("Ignoring file " + levelFolder.getName() + " because it is not a directory");
				continue;
			}

			if (!levelFolder.getName().matches("\\d{2,}Level")) {
				logger.info("Ignoring folder " + levelFolder.getName() + " because it is not a level");
			}

			String level = levelFolder.getName();

			logger.info("Saving level " + level);
			Path toSrcPath = Paths.get(String.format("%s/%s/%s/%s/%s/%s", volumeBasePath, classUTName, robotType, BASE_CODE_PATH, level, BASE_SRC_PATH));
			Path toTestPath = Paths.get(String.format("%s/%s/%s/%s/%s/%s", volumeBasePath, classUTName, robotType, BASE_CODE_PATH, level, BASE_TEST_PATH));
			Path toCoveragePath = Paths.get(String.format("%s/%s/%s/%s/%s", volumeBasePath, classUTName, robotType, BASE_COVERAGE_PATH, level));

			logger.info("Save SRC path " + toSrcPath);
			logger.info("Save TESTS path " + toTestPath);
			logger.info("Save COVERAGE path " + toCoveragePath);

			Path fromTestPath;
			Path fromCoveragePath;
			switch (robotType) {
				case "Evosuite":
					fromTestPath = Paths.get(String.format("%s/TestSourceCode/evosuite-tests", levelFolder));
					fromCoveragePath = Paths.get(String.format("%s/%s", levelFolder.getPath(), "TestReport"));
					break;
				case "Randoop":
				default:
					fromTestPath = Paths.get(String.format("%s", levelFolder));
					fromCoveragePath = Paths.get(String.format("%s", levelFolder.getPath()));
					break;
			}

			logger.info("Robot TESTS path " + fromTestPath);
			logger.info("Robot COVERAGE path " + fromCoveragePath);

			if (!Files.exists(fromTestPath)) {
				logger.info("Skipping folder " + fromTestPath + " because it does not exist");
				continue;
			}

			if (fromTestPath.toFile().listFiles().length == 0) {
				logger.info("Skipping folder " + fromTestPath + " because it does not have any files");
				continue;
			}

			if (Arrays.stream(fromTestPath.toFile().listFiles()).noneMatch(file -> file.getName().endsWith(".java"))) {
				logger.info("Skipping folder " + fromTestPath + " because it does not contain any .java files");
				continue;
			}

			String[][] splitPackageNames = saveTestFilesInVolume(fromTestPath, toTestPath, classUTName, robotType);
			String[] srcPackageNameSplit = splitPackageNames[0];
			saveSrcFileInVolume(classUTFile, toSrcPath, srcPackageNameSplit, classUTFileName);

			logger.info("SRC package names split " + Arrays.toString(srcPackageNameSplit));
			logger.info("TEST package names split " + Arrays.toString(splitPackageNames[1]));

			boolean[] coverageFound = saveCoverageFilesInVolume(fromCoveragePath, toCoveragePath);

			if (!coverageFound[1]) {
				Path srcCode_EvoSuiteTmp = Paths.get(String.format("%s/%s/%s", volumeBasePath, classUTName + "_EvoSuiteCoverage", BASE_SRC_PATH));
				Path testCodeT8_EvoSuiteTmp = Paths.get(String.format("%s/%s/%s", volumeBasePath, classUTName + "_EvoSuiteCoverage", BASE_TEST_PATH));

				splitPackageNames = saveTestFilesInVolume(fromTestPath, testCodeT8_EvoSuiteTmp, classUTName, robotType);
				String[] srcPackageName_EvoSuiteTmp = splitPackageNames[0];
				String[] testPackageName_EvoSuiteTmp = splitPackageNames[1];
				saveSrcFileInVolume(classUTFile, srcCode_EvoSuiteTmp, srcPackageName_EvoSuiteTmp, classUTFileName);

				String srcPackagePath = "";
				if (srcPackageName_EvoSuiteTmp != null) {
					srcPackagePath = String.join(".", srcPackageName_EvoSuiteTmp) + ".";
				}

				String testPackagePath = "";
				if (testPackageName_EvoSuiteTmp != null) {
					testPackagePath = String.join(".", testPackageName_EvoSuiteTmp) + ".";
				}

				Path evoSuiteWorkingPath = Paths.get(String.format("%s/%s", volumeBasePath, classUTName + "_EvoSuiteCoverage"));
				generateMissingEvoSuiteCoverage(classUTName, srcPackagePath, srcCode_EvoSuiteTmp, testCodeT8_EvoSuiteTmp, toCoveragePath, evoSuiteWorkingPath, testPackagePath);
			}

			if (!coverageFound[0]) {
				Path tmpFolder_ToZip = Paths.get(String.format("%s/%s/tmp_zip", volumeBasePath, classUTName));
				generateMissingJacocoCoverage(toSrcPath, toTestPath, tmpFolder_ToZip, toCoveragePath);
			}

			String jacocoCoveragePath = String.format("%s/coveragetot.xml", toCoveragePath);
			int[] evoSuiteStatistics = getEvoSuiteCoverageStatistics(String.format("%s/statistics.csv", toCoveragePath));

			logger.info("Evosuite Coverage: " + Arrays.toString(evoSuiteStatistics));
			int[][] jacocoStatistics = new int[][]{
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "LINE"),
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "BRANCH"),
					getJacocoCoverageByCoverageType(jacocoCoveragePath, "INSTRUCTION")
			};

			int levelInt = Integer.parseInt(levelFolder.toString().substring(levelFolder.toString().length() - 7, levelFolder.toString().length() - 5));
			String coverage = Files.lines(Paths.get(jacocoCoveragePath)).collect(Collectors.joining(System.lineSeparator()));
			uploadRobotCoverageInT4(evoSuiteStatistics, jacocoStatistics, levelInt, classUTName, robotType, coverage);
		}

		FileOperationUtil.deleteDirectoryRecursively(operationTmpFolder);
	}
}