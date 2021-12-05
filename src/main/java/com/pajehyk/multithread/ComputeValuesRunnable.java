package com.pajehyk.multithread;

import java.util.ArrayList;

public class ComputeValuesRunnable implements Runnable {
    private ArrayList<Double> contentArray;
    private ArrayList<Double> valuesArray;
    private Thread readingThread;
    private int curPos = 0;

    public ComputeValuesRunnable(ArrayList<Double> contentArray, ArrayList<Double> valuesArray, 
        Thread readingThread) {
        this.contentArray = contentArray;
        this.valuesArray = valuesArray;
        this.readingThread = readingThread;
    }

    public void run() {
        while (curPos < contentArray.size() || readingThread.isAlive()) {
            if (curPos < contentArray.size()) {
                double number = contentArray.get(curPos);
                valuesArray.add(Math.tan(number));
                curPos++;
            }
        }
    }
}
