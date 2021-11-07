package com.pajehyk.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Files class contains run() method that should recieve two arguments from command line 
 * which are chosen directory and output file in which the program writes paths of files,
 * containing in the directory.
 */
public class Files {
    private static String directoryPath;
    private static String outputPath;
    private static File directoryFile;
    private static File outputPathFile;

    /**
     * run() method that recieves path of directory and path of output file and write down 
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
        writeToFile("", outputPathFile, false);
        printDirectoryTree(directoryFile, outputPathFile);
    }

    /**
     * recursive method that scans the directory tree and write down files' paths to the
     * output file.
     *
     * @param directoryFile     path of the directory
     * @param outputPathFile    path of output file
     */
    public static void printDirectoryTree(File directoryFile, File outputPathFile) {
        File[] files = directoryFile.listFiles();
        if (!(files == null || files.length == 0)) {
            for (File file : files) {
                printDirectoryTree(file, outputPathFile);
            }
        }
        writeToFile(directoryFile.getPath() + '\n', outputPathFile, true);
    }
    
    public static void writeToFile(String stringToWrite, File outputFile, boolean override) {
        try {
            FileOutputStream fos = new FileOutputStream(outputPathFile, override);
            fos.write(stringToWrite.getBytes());
            fos.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
