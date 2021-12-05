package com.pajehyk;

import java.util.ArrayList;

import com.pajehyk.multithread.ComputeValuesRunnable;
import com.pajehyk.multithread.ReadFromFileRunnable;
import com.pajehyk.multithread.WriteToFileRunnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Double> contentArray = new ArrayList<>();
        ArrayList<Double> valuesArray = new ArrayList<>();
        Thread thread1 = new Thread(new ReadFromFileRunnable("src/main/resources/inputFile.txt", contentArray));
        Thread thread2 = new Thread(new ComputeValuesRunnable(contentArray, valuesArray, thread1));
        Thread thread3 = new Thread(new WriteToFileRunnable("src/main/resources/outputFile.txt", valuesArray, thread2));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
