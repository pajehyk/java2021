package com.pajehyk.files;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Files class contains main() method that should recieve two arguments from command line 
 * which are chosen directory and output file in which the program writes paths of files,
 * containing in the directory.
 */
public class Files {
    private static String directoryPath;
    private static String outputPath;
    private static File directoryFile;
    private static File outputPathFile;

    /**
     * main() method that recieves path of directory and path of output file and write down 
     * all files that contains in the directory into output file.
     *
     * @param args                          command line arguments
     * @throws InvalidArgumentsException    throws exception in case of wrong set of arguments    
     */
    public static void run(String[] args) throws InvalidArgumentsException {
        if (args.length != 2) { 
            throw new InvalidArgumentsException();
        }
        directoryPath = args[0];
        outputPath = args[1];
        directoryFile = new File(directoryPath);
        outputPathFile = new File(outputPath);
        printDirectoryTree(directoryFile, outputPathFile);
    }

    /**
     * recursive method that walk all over the directory tree and write down files' paths to the
     * output file.
     *
     * @param directoryFile     path of the directory
     * @param outputPathFile    path of output file
     */
    public static void printDirectoryTree(File directoryFile, File outputPathFile) {
        File[] files = directoryFile.listFiles();
        if (files == null || files.length == 0) {
            try { 
                FileOutputStream fos = new FileOutputStream(outputPathFile, true);
                String currentDirectoryPath = directoryFile.getPath() + '\n';
                fos.write(currentDirectoryPath.getBytes());
                fos.close();
            } catch (Throwable exc) {
                exc.printStackTrace();
            }
        } else {
            for (File file : files) {
                printDirectoryTree(file, outputPathFile);
            }
        }
    }
}
