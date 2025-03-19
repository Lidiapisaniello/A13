package com.robotchallenge.t8.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileOperationUtil {

    public static void copyDirectoryRecursively(Path sourcePath, Path destinationPath) throws IOException {
        if (!Files.exists(sourcePath) || !Files.isDirectory(sourcePath)) {
            throw new IllegalArgumentException(String.format("Il percorso %s sorgente non esiste o non è una directory.", sourcePath));
        }

        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = destinationPath.resolve(sourcePath.relativize(dir));
                Files.createDirectories(targetDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = destinationPath.resolve(sourcePath.relativize(file));
                Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void deleteDirectoryRecursively(Path dirPath) throws IOException {
        if (Files.isDirectory(dirPath)) {
            Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc != null) {
                        throw exc; // Solleva l'eccezione se la directory non può essere cancellata
                    }
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}
