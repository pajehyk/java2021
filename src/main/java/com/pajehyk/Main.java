package com.pajehyk;

import com.pajehyk.files.Files;
import com.pajehyk.files.InvalidArgumentsException;

public class Main {
    public static void main(String[] args) {
        try {
            Files.run(args);
        } catch (InvalidArgumentsException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
