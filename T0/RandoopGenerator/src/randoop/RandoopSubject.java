package randoop;

import interfaces.IObserver;
import interfaces.ISubject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
* I commenti sono stati aggiungi da ChatGPT.
 */
public class RandoopSubject implements ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private int cov, ex_cov, timelimit, iter, sat, livello;
    private static final int MAX_ITER = 5;
    private static final int MAX_SAT = 10;
    private static final int MAX_LEVEL = 10;

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void file_testing(File class_file) throws IOException {
        // Inizializzazione dei parametri
        cov = 0;
        ex_cov = 0;
        timelimit = 5;
        iter = 0;
        sat = 0;
        livello = 0;

        String classUTName = class_file.getName().replace(".java", "");

        System.out.println("Inizio test per la classe: " + class_file.getName());

        // Copia il file nella directory "classes"
        File file = new File("classes/" + class_file.getName());
        Files.copy(class_file.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Creazione directory di output
        File director = new File("./FolderTree/" + classUTName + "/RobotTest/RandoopTest/");
        director.mkdir();

        do {
            System.out.println("Esecuzione iterazione " + iter);

            // Esegui Randoop
            String[] result = RunRandoop.Run(class_file, timelimit, iter - 1, iter);
            notifyObservers();

            // Calcola coverage
            cov = EmmaCoverage.LineCoverage(result[1]);

            if (ex_cov >= cov) {
                sat++;
                System.out.println("Copertura invariata. Incremento sat: " + sat);
            } else {
                livello++;
                sat = 0;
                ex_cov = cov;
                System.out.println("Nuovo livello raggiunto: " + livello + " - Copertura: " + cov);

                File directory_level = new File("./FolderTree/" + classUTName +
                        "/RobotTest/RandoopTest/" + (livello < 10 ? "0" : "") + livello + "Level");
                directory_level.mkdir();

                for (int i = 0; i <= iter; i++) {
                    File sourceFile = new File("./FolderTree/" + classUTName +
                            "/RobotTest/RandoopTest/" + classUTName + "-" + i + "-dati_di_copertura/");

                    File[] files = sourceFile.listFiles();
                    if (files != null) {
                        try {
                            Path origine = new File(sourceFile, "coveragetot.xml").toPath();
                            Path destinazione = new File(directory_level, "coveragetot.xml").toPath();
                            Files.copy(origine, destinazione, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("File coveragetot.xml copiato.");
                        } catch (IOException e) {
                            System.err.println("Errore copia coveragetot.xml: " + e.getMessage());
                        }

                        for (File f : Objects.requireNonNull(new File(sourceFile, String.format("%s_Test", classUTName)).listFiles())) {
                            if (f.isFile() && f.getName().endsWith(".java")) {
                                Files.copy(f.toPath(), new File(directory_level, f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            }
                        }
                    }
                }
            }

            iter++;
            timelimit += 2;
        } while (iter < MAX_ITER && sat < MAX_SAT && livello < MAX_LEVEL);


        // Pulizia della cartella "classes"
        System.out.println("Pulizia cartella classes...");
        FolderOperations.clearFolder();
        for (File classFile : new File("./classes").listFiles()) {
            classFile.delete();
        }

        System.out.println("Test completato per " + class_file.getName());
    }
}