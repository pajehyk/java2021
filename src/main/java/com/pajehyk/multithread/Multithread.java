package com.pajehyk.multithread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithread {
    private String inputFilePath;
    private String outputFilePath;
    private ArrayList<Double> contentArray = new ArrayList<>();
    private ArrayList<Double> valuesArray = new ArrayList<>();
    private Object[] values;

    public Multithread(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void compute(int nThreads) throws InterruptedException, ExecutionException {
        final long startTime = System.currentTimeMillis();
        readFromFile(inputFilePath, contentArray);
        computeValues(contentArray, valuesArray, nThreads);
        writeToFile(outputFilePath, valuesArray);
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public void readFromFile(String filePath, ArrayList<Double> contentArray) {
        try (Scanner scan = new Scanner(new FileInputStream(new File(filePath)))) {
            while (scan.hasNextDouble()) {
                double number = scan.nextDouble();
                contentArray.add(number);
            }
        } catch (FileNotFoundException exc) {
            System.out.println(exc.getMessage());
        }   
    }

    public void computeValues(ArrayList<Double> contentArray, ArrayList<Double> valuesArray, int nThreads) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        int size = contentArray.size();
        values = new Object[size];
        for (int i = 0; i < size; i++) {
            int j = i;
            values[i] = executor.submit(() -> {
                return Math.tan(contentArray.get(j));
            });
        }
        executor.shutdown();
    }

    public void writeToFile(String filePath, ArrayList<Double> valuesArray) throws InterruptedException, ExecutionException {
        try (PrintStream ps = new PrintStream(new File(filePath))) {
            for (int i = 0; i < contentArray.size(); i++) {
                ps.println(((Future<Double>) values[i]).get());
            }
        } catch (FileNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
    }
}