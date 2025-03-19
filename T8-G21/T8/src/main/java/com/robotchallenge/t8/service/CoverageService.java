package com.robotchallenge.t8.service;

import com.robotchallenge.t8.dto.request.RobotCoverageRequestDTO;
import com.robotchallenge.t8.dto.request.StudentCoverageRequestDTO;
import com.robotchallenge.t8.util.FileOperationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CoverageService {

    private static final Logger logger = LoggerFactory.getLogger(CoverageService.class);

    public String calculateRobotCoverage(RobotCoverageRequestDTO request) throws RuntimeException {
        String evosuiteWorkingDir = request.getEvosuiteWorkingDir();

        // Creo la directory temporanea dove copiare i sorgenti ed eseguire EvoSuite
        String currentCWD = Paths.get(".").toAbsolutePath().normalize().toString();
        logger.info("[calculateRobotCoverage] CWD: {}", currentCWD);

        // TODO: Attualmente le operazioni di coverage vengono eseguite all'interno del VOLUMET0, da modificare
        //Files.createDirectory(Paths.get(currentCWD, evosuiteWorkingDir));
        //Path evoSuiteWorkingDirPath = Paths.get(currentCWD, evosuiteWorkingDir);

        // Copio evosuite e pom
        try {
            Files.copy(Paths.get(currentCWD, "evosuite", "evosuite-1.0.6.jar"), Paths.get(evosuiteWorkingDir, "evosuite-1.0.6.jar"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(currentCWD, "evosuite", "evosuite-standalone-runtime-1.0.6.jar"), Paths.get(evosuiteWorkingDir, "evosuite-standalone-1.0.6.jar"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(currentCWD, "evosuite", "pom2.xml"), Paths.get(evosuiteWorkingDir, "pom.xml"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException | NullPointerException e) {
            logger.error("[calculateRobotCoverage] Errore durante la copia di evosuite/pom.xml: ", e);
            throw new RuntimeException("[calculateRobotCoverage] Errore durante la copia di evosuite/pom.xml: " + e);
        }

        String result = calculateEvosuiteCoverage(evosuiteWorkingDir, request.getClassUTPackage(), request.getClassUTName());

        try {
            FileOperationUtil.deleteDirectoryRecursively(Path.of(evosuiteWorkingDir));
        } catch (IOException e) {
            logger.error("[calculateRobotCoverage] Errore durante il cleanup: ", e);
            throw new RuntimeException("[calculateRobotCoverage] Errore durante il cleanup: " + e);
        }

        return result;
    }

    public int[] calculateStudentCoverage(StudentCoverageRequestDTO request) throws RuntimeException {
        String operationDir = request.getUserDir();
        String classUTName = request.getClassUTName();
        String testCode = request.getTestCode();

        String srcDir = String.format("%s/src/java/main", operationDir);
        String testDir = String.format("%s/src/test/main", operationDir);
        String coverageDir = String.format("%s/coverage", operationDir);
        try {
            Files.createDirectories(Paths.get(srcDir));
            Files.createDirectories(Paths.get(testDir));
            Files.createDirectories(Paths.get(coverageDir));
        } catch (IOException | NullPointerException e) {
            logger.error("[calculateStudentCoverage] Errore durante la creazione delle cartelle del progetto in VolumeT0: ", e);
            throw new RuntimeException("[calculateStudentCoverage] Errore durante la creazione delle cartelle del progetto in VolumeT0: " + e);
        }

        try {
            Files.copy(Paths.get(request.getClassUTPath()), Paths.get(srcDir, classUTName + ".java"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new ByteArrayInputStream(testCode.getBytes()), Paths.get(testDir, "Test" + classUTName + ".java"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException | NullPointerException e) {
            logger.error("[calculateStudentCoverage] Errore durante la copia dei sorgenti in VolumeT0: ", e);
            throw new RuntimeException("[calculateStudentCoverage] Errore durante la copia dei sorgenti in VolumeT0: " + e);
        }

        String currentCWD = Paths.get(".").toAbsolutePath().normalize().toString();
        logger.info("[calculateStudentCoverage] CWD: {}", currentCWD);

        String baseCwd = String.format("%s/%s", currentCWD, "EvoSuite_Coverage_" + generateTimestamp());
        String cwdSrc = String.format("%s/src/main/java", baseCwd);
        String cwdTest = String.format("%s/src/test/java", baseCwd);
        try {
            Files.createDirectory(Paths.get(baseCwd));
            FileOperationUtil.copyDirectoryRecursively(Paths.get(srcDir), Paths.get(cwdSrc));
            FileOperationUtil.copyDirectoryRecursively(Paths.get(testDir), Paths.get(cwdTest));
            Files.copy(Paths.get(currentCWD, "evosuite", "evosuite-1.0.6.jar"), Paths.get(baseCwd, "evosuite-1.0.6.jar"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(currentCWD, "evosuite", "evosuite-standalone-runtime-1.0.6.jar"), Paths.get(baseCwd, "evosuite-standalone-1.0.6.jar"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(currentCWD, "evosuite", "pom2.xml"), Paths.get(baseCwd, "pom.xml"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error("[calculateStudentCoverage] Errore durante la copia nel file system locale del progetto utente (src|test|evosuite|pom.xml): ", e);
            throw new RuntimeException("[calculateStudentCoverage] Errore durante la copia nel file system locale del progetto utente (src|test|evosuite|pom.xml): " + e);
        }

        String result = calculateEvosuiteCoverage(baseCwd, request.getClassUTPackage(), request.getClassUTName());

        try {
            Files.copy(new ByteArrayInputStream(result.getBytes()), Paths.get(coverageDir, "statistics.csv"), StandardCopyOption.REPLACE_EXISTING);
            FileOperationUtil.deleteDirectoryRecursively(Path.of(baseCwd));
            return getCoveragePercentageStatistics(result);
        } catch (IOException | NullPointerException e) {
            logger.error("[calculateStudentCoverage] Errore durante la copia dei sorgenti in VolumeT0: ", e);
            throw new RuntimeException("[calculateStudentCoverage] Errore durante la copia dei sorgenti in VolumeT0: " + e);
        }
    }

    private String calculateEvosuiteCoverage(String workingDir, String classUTPackage, String classUTName) {
        // Preparo evosuite per la coverage
        runCommand(workingDir, 15, "mvn", "clean", "install");
        runCommand(workingDir, 15, "mvn", "dependency:copy-dependencies");

        String projectCP = workingDir + "/target/classes:" + workingDir + "/target/test-classes";
        List<String> criteria = Arrays.asList("LINE", "BRANCH", "EXCEPTION", "WEAKMUTATION", "OUTPUT", "METHOD", "METHODNOEXCEPTION", "CBRANCH");

        for (String criterion : criteria) {
            runCommand(workingDir, 30, "/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", workingDir + "/evosuite-1.0.6.jar",
                    "-measureCoverage", "-class", classUTPackage + classUTName,
                    "-projectCP", projectCP, "-Dcriterion=" + criterion);
        }

        Path coverageFilePath = Paths.get(workingDir, "evosuite-report", "statistics.csv");

        try (Stream<String> coverage = Files.lines(coverageFilePath)) {
            return coverage.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            logger.error("[calculateEvosuiteCoverage] Errore durante la lettura di statistics.csv: ", e);
            throw new RuntimeException("[calculateEvosuiteCoverage] Errore durante la lettura di statistics.csv: " + e);
        }
    }

    private void runCommand (String workingDir, Integer timer, String ...command){
        Process process = null;
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            ProcessBuilder processBuilder = new ProcessBuilder();

            // Forzo l'uso di Java 8 per evosuite
            processBuilder.environment().put("JAVA_HOME", "/usr/lib/jvm/java-8-openjdk-amd64");
            processBuilder.environment().put("PATH", "/usr/lib/jvm/java-8-openjdk-amd64/bin:" + System.getenv("PATH"));

            // Mi sposto nella nuova working directory
            processBuilder.directory(new File(workingDir));
            processBuilder.redirectErrorStream(true);
            processBuilder.command(command);
            process = processBuilder.start();

            Process finalProcess = process;
            executor.submit(() -> streamGobbler(finalProcess.getInputStream(), "OUTPUT"));
            executor.submit(() -> streamGobbler(finalProcess.getErrorStream(), "ERROR"));

            logger.info("[runCommand] Avviato timer {} per comando {}", timer, command);
            boolean finished = process.waitFor(timer, TimeUnit.MINUTES);

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);

            if (!finished) {
                process.destroyForcibly();
                logger.error("[runCommand] Timeout superato. Processo terminato forzatamente.");
                throw new RuntimeException("[runCommand] Timeout superato. Processo terminato forzatamente.");
            }
        } catch (IOException e) {
            logger.error("[runCommand] Errore: {}", e.getMessage());
            throw new RuntimeException("[runCommand] Errore I/O: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            logger.error("[runCommand] Errore: {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException("[runCommand] Processo interrotto: " + e.getMessage(), e);
        } finally {
            if (process != null && process.isAlive())
                process.destroyForcibly();
        }
    }

    private static void streamGobbler (InputStream inputStream, String streamType){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + streamType + "] " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] getCoveragePercentageStatistics(String content) {
        List<Integer> values = new ArrayList<>();
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new StringReader(content))) {
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
                        logger.error("[getCoveragePercentageStatistics] Errore durante la conversione dei valori di copertura percentuale: {}", e.getMessage());
                        throw new RuntimeException("[getCoveragePercentageStatistics] Errore durante la conversione dei valori di copertura percentuale: " + e.getMessage(), e);

                    }
                }
            }
        } catch (IOException e) {
            logger.error("[getCoveragePercentageStatistics] Errore durante l'estrazione della colonna della copertura percentuale: {}", e.getMessage());
            throw new RuntimeException("[getCoveragePercentageStatistics] Errore durante l'estrazione della colonna della copertura percentuale: " + e.getMessage(), e);
        }

        // Converto la lista in array di interi
        return values.stream().mapToInt(i -> i).toArray();
    }

    private String generateTimestamp() {
        //questa funzione è thread safe
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        // Genera 4 cifre random thread-safe
        int randomFourDigits = ThreadLocalRandom.current().nextInt(1000, 10000); // 1000 (incluso) e 10000 (escluso)
        // Concatena il timestamp e le cifre casuali
        return timestamp + randomFourDigits;
    }

}
