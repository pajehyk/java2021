package com.pajehyk.multithread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFileRunnable implements Runnable {
    private File file;
    private ArrayList<Double> contentArray;
    public ReadFromFileRunnable(String filePath, ArrayList<Double> contentArray) {
        this.file = new File(filePath);
        this.contentArray = contentArray;
    }
    public void run() {
        try(FileInputStream fis = new FileInputStream(file); Scanner scan = new Scanner(fis)) {
            while(scan.hasNextDouble()) {
                double number = scan.nextDouble();
                contentArray.add(number);
            }
        } catch(FileNotFoundException exc) {
            System.out.println(exc.getMessage());
        } catch(IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
