package com.pajehyk.files;

import java.io.File;
import java.io.FileOutputStream;

public class Files {
    private static String directoryPath;
    private static String outputPath;
    private static File directoryFile;
    private static File outputPathFile;
    public static void main(String[] args) throws Throwable {
        if (args.length != 2) throw new InvalidArgumentsException();
        directoryPath = args[0];
        outputPath = args[1];
        directoryFile = new File(directoryPath);
        outputPathFile = new File(outputPath);
        printDirectoryTree(directoryFile, outputPathFile);
    }

    public static void printDirectoryTree(File directoryFile, File outputPathFile) {
        File[] files = directoryFile.listFiles();
        if (files == null || files.length == 0) {
            try { 
                FileOutputStream fos = new FileOutputStream(outputPathFile, true);
                String currentDirectoryPath = directoryFile.getPath() + '\n';
                fos.write(currentDirectoryPath.getBytes());
                fos.close();
            }
            catch (Throwable exc) {
                exc.printStackTrace();
            }
        } else {
            for (File file: files) {
                printDirectoryTree(file, outputPathFile);
            }
        }
    }
}
