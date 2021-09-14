package com.mblagov.operators;

public class Conditions {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error, please add at least one argument");
            return;
        }

        String firstArg = args[0];
        switch (firstArg) {
            case "a":
                System.out.println("a-arg branch");
                break;
            case "b":
                System.out.println("b-arg branch");
                break;
            case "c":
                System.out.println("c-arg branch");
                break;
            default:
                System.out.println("default branch");
        }
    }
}
