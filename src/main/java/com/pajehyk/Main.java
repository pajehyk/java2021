package com.pajehyk;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import com.pajehyk.multithread.Multithread;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {
        Multithread mt = new Multithread("src/main/resources/input1000000.txt", "src/main/resources/outputFile.txt");
        mt.compute(2);
    }   
}
