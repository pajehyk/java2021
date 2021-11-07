package com.pajehyk;

import java.io.FileNotFoundException;

import com.pajehyk.atm.Atm;

public class Main {
    public static void main(String[] args) {
        try {
            Atm.run();
        } catch(FileNotFoundException exc) {
            System.out.println("File not found");
        }
    }
}
