package com.pajehyk.atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for computing number of different combinations of given banknotes which in sum gives 
 * certain number.
 */
public class Atm {
    static int givenSum; 
    static int numberOfBanknotes;
    static ArrayList<Integer> banknotesValues = new ArrayList<>(); // Banknotes values
    static int numberOfAnswers = 0; 
    static ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    /**
     * Main method of Atm class, scans for input data and calls atmCompute() method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        readInputData(System.in);
        atmCompute(true, 0, 0, new ArrayList<>());
        writeOutputData(System.out);
    }

    public static void readInputData(InputStream input) {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        try {
            String st = in.readLine();
            givenSum = Integer.parseInt(st);
            st = in.readLine();
            int ind = 0;
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == ' ') {
                    banknotesValues.add(Integer.parseInt(st.substring(ind, i)));
                    ind = i + 1;
                    numberOfBanknotes++;
                }
            }
            banknotesValues.add(Integer.parseInt(st.substring(ind, st.length())));
            numberOfBanknotes++;
        }
        catch (IOException exc) {};
    }

    public static void writeOutputData(OutputStream output) {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write(answerList.toString());
            out.flush();
        }
        catch (IOException exc) {};
    }
    

    /** 
     * Method that computes combination and stores them in takenBanknotes ArrayList. 
     *
     * @param firstRun          boolean parameter defining the first call of the method 
     * @param recursiveSum      sum of numbers at the current iteration
     * @param currentBanknote   index of a banknote at the current iteration
     * @param takenBanknotes    values of baknotes that were taken in the combination at the 
     *                          current iteration
     */
    public static void atmCompute(boolean firstRun, int recursiveSum, 
        int currentBanknote, ArrayList<Integer> takenBanknotes) {
        if (firstRun) {
            answerList.add(new ArrayList<>());
            answerList.get(0).add(0);
        }
        if (recursiveSum >= givenSum || currentBanknote >= numberOfBanknotes) {
            if (recursiveSum == givenSum) {
                answerList.add(new ArrayList<>(takenBanknotes));
                answerList.get(0).set(0, answerList.get(0).get(0) + 1);
            }
        } else {
            takenBanknotes.add(banknotesValues.get(currentBanknote));
            atmCompute(false, recursiveSum + banknotesValues.get(currentBanknote), currentBanknote, 
                takenBanknotes);
            takenBanknotes.remove(takenBanknotes.size() - 1);
            atmCompute(false, recursiveSum, currentBanknote + 1, takenBanknotes);
        }
    }
}
