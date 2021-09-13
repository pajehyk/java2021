package com.mblagov;

/**
 * Sample class to show how the console application should look like.
 */
public class Sample {

    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println(sample.getMessage());
    }

    public String getMessage() {
        return "My message";
    }
}
