package com.mblagov.animals;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Main class for Animals.
 */
public class Animal {

    String name;

    public void sayHello(OutputStream out) {
        new PrintStream(out).println(getMessage());
    }

    public String getMessage() {
        return "";
    }

    public double getWeight() {
        return 1;
    }

}
