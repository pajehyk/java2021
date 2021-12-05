package com.pajehyk.multithread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class WriteToFileRunnable implements Runnable {
    private File file;
    private ArrayList<Double> valuesArray;
    private int curPos = 0;
    private Thread readingThread;

    public WriteToFileRunnable(String filePath, ArrayList<Double> valuesArray, Thread readingThread) {
        this.file = new File(filePath);
        this.valuesArray = valuesArray;
        this.readingThread = readingThread;
    }
    public void run() {
        try (PrintStream ps = new PrintStream(file)) {
            while (readingThread.isAlive() || curPos < valuesArray.size()) {
                if (curPos < valuesArray.size()) {
                    ps.println(valuesArray.get(curPos));
                    curPos++;
                }
            }
        } catch (FileNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
