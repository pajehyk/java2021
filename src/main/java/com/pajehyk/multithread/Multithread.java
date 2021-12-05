package com.pajehyk.multithread;

import java.util.ArrayList;

public class Multithread {
    private String inputFilePath;
    private String outputFilePath;

    public Multithread(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }
    public void start() {
        final long startTime = System.currentTimeMillis();
        ArrayList<Double> contentArray = new ArrayList<>();
        ArrayList<Double> valuesArray = new ArrayList<>();
        Thread thread1 = new Thread(new ReadFromFileRunnable(inputFilePath, 
            contentArray));
        Thread thread2 = new Thread(new ComputeValuesRunnable(contentArray, 
            valuesArray, thread1));
        Thread thread3 = new Thread(new WriteToFileRunnable(outputFilePath, 
            valuesArray, thread2));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime));
    }
}
