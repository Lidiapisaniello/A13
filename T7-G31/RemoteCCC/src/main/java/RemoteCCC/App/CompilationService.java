/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package RemoteCCC.App;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLockInterruptionException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import RemoteCCC.App.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

//@Service
public class CompilationService {
    /*
     * Config gestisce i path delle directory e fornisce un id univoco 
     * serve solo per non tenere tutta la logica qua
     */
    protected final Config config;
    private final String testingClassName;
    private final String testingClassCode;
    private final String underTestClassName;
    private final String underTestClassCode;
    /*
     *  Qui metto tutte le variabili che ottengo come output
     *  Attenzione outputMaven viene settato da compileExecuteCoverageWithMaven()
     *  mentre errors e Coverage in base al suo valore vengono settati da compileAndTest
     */
    public String outputMaven;
    public Boolean Errors;
    public String Coverage;
    /*
     *  Qui metto il path di maven in base al profilo, 
     *  in fase di testing ho bisogno di esplicitarlo rispetto a windows
     */
    @Value("${variabile.mvn}")
    private String mvn_path;

    //logger
    protected static final Logger logger = LoggerFactory.getLogger(CompilationService.class);

    public CompilationService(String testingClassName, String testingClassCode,
                              String underTestClassName, String underTestClassCode, 
                              String mvn_path) {
        
        this.config = new Config();
        this.testingClassName = testingClassName;
        this.testingClassCode = testingClassCode;
        this.underTestClassName = underTestClassName;
        this.underTestClassCode = underTestClassCode;
        this.outputMaven = null;
        this.mvn_path = mvn_path;
        logger.info("[CompilationService] Servizi creato con successo");
    }

    public CompilationService(String mvn_path) {

        this.config = new Config();
        this.underTestClassName = null;
        this.underTestClassCode = null;
        this.outputMaven = null;
        this.testingClassName = null;
        this.testingClassCode = null;
        this.mvn_path = mvn_path;
        logger.info("[CompilationService] Servizi creato con successo");
    }

    public void compileAndTestEvoSuiteTests(MultipartFile evoSuiteCode) throws IOException, InterruptedException {
        try {
            createDirectoryIfNotExists(config.getPathCompiler());
            logger.info("[Compilation Service] directory creata con successo: {}", config.getPathCompiler());

            evoSuiteCode.transferTo(new File(String.format("%s/%s", config.getPathCompiler(), Objects.requireNonNull(evoSuiteCode.getOriginalFilename()))));
            FileUtil.unzip(String.format("%s/%s", config.getPathCompiler(), Objects.requireNonNull(evoSuiteCode.getOriginalFilename())), new File(String.format("%s", config.getPathCompiler())));

            copyPomFileForEvoSuiteTest();
            logger.info("[CompilationService] Avvio Maven");
            if (compileExecuteCoverageWithMaven(true, "clean", "test", "jacoco:restore-instrumented-classes", "jacoco:report")) {
                this.Coverage = readFileToString(config.getCoverageFolderPath());
                this.Errors = false;
                logger.info("Coverage: ");
                logger.info(this.Coverage);
                logger.info("[Compilation Service] Compilazione Terminata senza errori.");
            } else {
                this.Coverage = null;
                this.Errors = true;
                logger.info("[Compilation Service] Compilazione Terminata con errori");
                logger.info("[Compilation Service] Errori: {}", outputMaven);
            }

            //FileUtil.deleteDirectoryRecursively(Paths.get(config.getPathCompiler()));
        } catch (FileConcurrencyException e) {
            logger.error("[Compilation Service] [LOCK ERROR] ", e);
        } catch (IOException e) {
            logger.error("[Compilation Service] [I/O ERROR] ", e);
        } catch (IllegalArgumentException e) {
            logger.error("[Compilation Service] [ARGS ERROR] ", e);
        } catch (RuntimeException e) {
            logger.error("[Compilation Service] [RUNTIME ERROR] ", e);
        } catch (Exception e) {
            logger.error("[Compilation Service] [GENERIC ERROR] ", e);
        }
    }


    public void compileAndTest() throws IOException, InterruptedException {
        try {
            createDirectoriesAndCopyPom();
            saveCodeToFile(this.testingClassName, this.testingClassCode, config.getTestingClassPath());
            saveCodeToFile(this.underTestClassName, this.underTestClassCode, config.getUnderTestClassPath());
            logger.info("[CompilationService] Avvio Maven");
            if (compileExecuteCoverageWithMaven(false, "clean", "compile", "test")) {
                this.Coverage = readFileToString(config.getCoverageFolderPath());
                this.Errors = false;
                logger.info("[Compilation Service] Compilazione Terminata senza errori.");
            } else {
                this.Coverage = null;
                this.Errors = true;
                logger.info("[Compilation Service] Compilazione Terminata con errori");
            }
            deleteFile(config.getUnderTestClassPath() + underTestClassName);
            deleteFile(config.getTestingClassPath() + testingClassName);
            deleteTemporaryDirectories(config.getPathCompiler());
            logger.info("[CompilationService] File termporanei eliminati");
        } catch (FileConcurrencyException e) {
            logger.error("[Compilation Service] [LOCK ERROR] ", e);
        } catch (IOException e) {
            logger.error("[Compilation Service] [I/O ERROR] ", e);
        } catch (IllegalArgumentException e) {
            logger.error("[Compilation Service] [ARGS ERROR] ", e);
        } catch (RuntimeException e) {
            logger.error("[Compilation Service] [RUNTIME ERROR] ", e);
        } catch (Exception e) {
            logger.error("[Compilation Service] [GENERIC ERROR] ", e);
        }
    }

    protected void createDirectoriesAndCopyPom() throws IOException {
        /*
             *   Creo la cartella usrPath/timestamp/
             *   poi creo  usrPath/timestamp/src/main/java/
             *   e usrPath/timestamp/test/main/java/
             *   infine per il report della cov userPath/timestamp/target/site/
         */
        createDirectoryIfNotExists(config.getPathCompiler());
        logger.info("[Compilation Service] directory creata con successo: {}", config.getPathCompiler());

        copyPomFile();
        logger.info("[Compilation Service] pom file creato con successo {}", config.getPathCompiler() + "pom.xml");

        createDirectoryIfNotExists(config.getTestingClassPath());
        logger.info("[Compilation Service] directory creata con successo: {}", config.getTestingClassPath());

        createDirectoryIfNotExists(config.getUnderTestClassPath());
        logger.info("[Compilation Service] directory creata con successo: {}", config.getUnderTestClassPath());

        createDirectoryIfNotExists(config.getCoverageFolderPath());
        logger.info("[Compilation Service] directory creata con successo: {}", config.getCoverageFolderPath());
    }

    protected void createDirectoryIfNotExists(String path) throws IOException {
        File directory = new File(path);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("[createDirectoryIfNotExists] Impossibile creare la directory: " + path);
            }
        } else {
            throw new IOException("[createDirectoryIfNotExists] Errore esiste già la directory: " + path);
        }
    }

    private void copyPomFile() throws IOException {
        File pomFile = new File(config.getUsrPath() + config.getsep() + "ClientProject" + config.getsep() + "pom.xml");
        File destPomFile = new File(config.getPathCompiler() + "pom.xml");

        // Controlla se il file pom.xml esiste prima di tentare di copiarlo
        if (!pomFile.exists()) {
            throw new IOException("[Compilation Service] Il file pom.xml non esiste: " + pomFile.getAbsolutePath());
        } 
        /*
        *   Questa classe implementa un tipo di lock che distingue tra operazioni di lettura e scrittura, 
        *   consentendo a più thread di leggere simultaneamente, 
        *   ma limitando l'accesso esclusivo per le operazioni di scrittura.
        */
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        /*
        *    Col filechannel rende l'operazione atomica
        */
        FileChannel sourceChannel = FileChannel.open(pomFile.toPath(), StandardOpenOption.READ); 
        FileChannel destChannel   = FileChannel.open(destPomFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        readLock.lock();
        try {
            long size = sourceChannel.size();
            long position = 0;
            while (position < size) {
                position += sourceChannel.transferTo(position, size - position, destChannel);
            }
        } catch (OverlappingFileLockException e) {
            throw new FileConcurrencyException("[copyPomFile] FileLock concorrente sul file sorgente: " + e.getMessage(), e);
        } catch (FileLockInterruptionException e) {
            throw new FileConcurrencyException("[copyPomFile] L'acquisizione del lock è stata interrotta: " + e.getMessage(), e);
        } catch (NonWritableChannelException e) {
            throw new FileConcurrencyException("[copyPomFile] Canale di scrittura non valido per acquisire il lock: " + e.getMessage(), e);
        } catch (ClosedChannelException e) {
            throw new FileConcurrencyException("[copyPomFile] Il canale è stato chiuso prima di acquisire il lock: " + e.getMessage(), e);
        }finally {
            readLock.unlock();
        }
    }

    private void copyPomFileForEvoSuiteTest() throws IOException {
        File pomFile = new File(config.getUsrPath() + config.getsep() + "EvoSuite" + config.getsep() + "pom.xml");
        File destPomFile = new File(config.getPathCompiler() + config.getsep() + "pom.xml");

        // Controlla se il file pom.xml esiste prima di tentare di copiarlo
        if (!pomFile.exists()) {
            throw new IOException("[Compilation Service] Il file pom.xml non esiste: " + pomFile.getAbsolutePath());
        }
        /*
         *   Questa classe implementa un tipo di lock che distingue tra operazioni di lettura e scrittura,
         *   consentendo a più thread di leggere simultaneamente,
         *   ma limitando l'accesso esclusivo per le operazioni di scrittura.
         */
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        /*
         *    Col filechannel rende l'operazione atomica
         */
        FileChannel sourceChannel = FileChannel.open(pomFile.toPath(), StandardOpenOption.READ);
        FileChannel destChannel   = FileChannel.open(destPomFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        readLock.lock();
        try {
            long size = sourceChannel.size();
            long position = 0;
            while (position < size) {
                position += sourceChannel.transferTo(position, size - position, destChannel);
            }
        } catch (OverlappingFileLockException e) {
            throw new FileConcurrencyException("[copyPomFile] FileLock concorrente sul file sorgente: " + e.getMessage(), e);
        } catch (FileLockInterruptionException e) {
            throw new FileConcurrencyException("[copyPomFile] L'acquisizione del lock è stata interrotta: " + e.getMessage(), e);
        } catch (NonWritableChannelException e) {
            throw new FileConcurrencyException("[copyPomFile] Canale di scrittura non valido per acquisire il lock: " + e.getMessage(), e);
        } catch (ClosedChannelException e) {
            throw new FileConcurrencyException("[copyPomFile] Il canale è stato chiuso prima di acquisire il lock: " + e.getMessage(), e);
        }finally {
            readLock.unlock();
        }
    }

    private void saveCodeToFile(String nameclass, String code, String path) throws IOException {
        // Controlla che il nome della classe e il percorso siano validi
        if (nameclass == null || nameclass.isEmpty()) {
            throw new IllegalArgumentException("[saveCodeToFile] Il nome della classe non può essere nullo o vuoto.");
        }
        if(!nameclass.endsWith(".java")){
            throw new IllegalArgumentException("[saveCodeToFile] Il nome della classe non ha l'estensione .java");
        }
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("[saveCodeToFile] Il percorso non può essere nullo o vuoto.");
        }
        // Aggiungi la dichiarazione del pacchetto al codice
        String packageDeclaration = config.getPackageDeclaration();
        code = packageDeclaration + code;
        //creo il file di destinazione 
        File tempFile = new File(path + nameclass);
        // Imposta il file per la cancellazione all'uscita
        tempFile.deleteOnExit();
        // Utilizza FileChannel per scrivere in modo atomico
        try (FileChannel channel = FileChannel.open(tempFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            logger.info("[CompilationService] Ho creato il file " + path + nameclass);
            ByteBuffer buffer = StandardCharsets.UTF_8.encode(code);
            channel.write(buffer);
        } catch (IOException e) {
            throw new IOException("[saveCodeToFile] Errore durante la scrittura nel file: " + tempFile.getAbsolutePath(), e);
        }
    }

    private boolean compileExecuteCoverageWithMaven(boolean compileForEvoSuite, String ...arguments) throws RuntimeException{
        logger.error(mvn_path);

        String[] command = new String[arguments.length + 1];
        command[0] = mvn_path;
        System.arraycopy(arguments, 0, command, 1, arguments.length);

        // Configurazione del processo
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(config.getPathCompiler()));
        StringBuilder output = new StringBuilder();
        StringBuilder errorOutput = new StringBuilder();
        Process process = null;

        if (compileForEvoSuite)
            processBuilder.environment().put("JAVA_HOME", "/usr/lib/jvm/java-8-openjdk-amd64");
        try {
            // Avvia il processo
            process = processBuilder.start();
            // Leggi l'output standard e l'errore in thread separati per evitare deadlock
            readProcessOutput(process, output, errorOutput);
            // Attendi la fine del processo con un timeout (es. 15 minuti)
            boolean finished = process.waitFor(15, TimeUnit.MINUTES);
            if (!finished) {
                process.destroyForcibly(); // Uccidi il processo se supera il timeout
                throw new RuntimeException("[compileExecuteCoverageWithMaven] Timeout superato. Il processo Maven è stato forzatamente interrotto.");
            }
            this.outputMaven += output.toString();
            // Verifica se il processo è terminato con successo
            return (process.exitValue()) == 0;
        } catch (IOException e) {
            logger.error("[Compilation Service] [MAVEN] {}", errorOutput);
            throw new RuntimeException("[compileExecuteCoverageWithMaven] Errore di I/O durante l'esecuzione del processo Maven: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            logger.error("[Compilation Service] [MAVEN] {}", errorOutput);
            Thread.currentThread().interrupt(); // Ripristina lo stato di interruzione
            throw new RuntimeException("[compileExecuteCoverageWithMaven] Processo Maven interrotto: " + e.getMessage(), e);
        } finally {
            // Assicurati che il processo sia terminato correttamente
            if (process != null && process.isAlive()) {
                process.destroyForcibly();
            }
        }
    }

    private void readProcessOutput(Process process, StringBuilder output, StringBuilder errorOutput) throws IOException, InterruptedException {
        try (
             BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream())); 
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))
            ) {
            // Leggi l'output standard
            String line;
            while ((line = outputReader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }
            // Leggi l'output di errore
            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append(System.lineSeparator());
            }
        }
    }

    private void deleteFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("[deleteFile] Impossibile eliminare il file: " + file.getAbsolutePath());
            }
        } else {
            throw new IllegalArgumentException("[deleteFile] Il file non esiste: " + file.getAbsolutePath());
        }
    }

    private void deleteTemporaryDirectories(String path) throws IOException {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            try {
                FileUtils.deleteDirectory(dir);
            } catch (IOException e) {
                throw new IOException("[deleteTemporaryDirectories] Errore durante l'eliminazione della directory temporanea: " + dir.getAbsolutePath(), e);
            }
        } else {
            throw new IOException("[deleteTemporaryDirectories] La directory non esiste o non è valida: " + dir.getAbsolutePath());
        }
    }

    protected void deleteCartelleTest() throws IOException {
        deleteTemporaryDirectories(config.getPathCompiler());
    }

    private String readFileToString(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes);
    }

    private void unzip(String fileZip, File destDir) throws IOException {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = new File(destDir, zipEntry.getName());
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // Aggiustamento per archivi creati con Windows
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // Scrittura del contenuto del file
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    //mi serve per distingure le eccezioni sulla concorrenza 
    public class FileConcurrencyException extends IOException {

        public FileConcurrencyException(String message) {
            super(message);
        }

        public FileConcurrencyException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
