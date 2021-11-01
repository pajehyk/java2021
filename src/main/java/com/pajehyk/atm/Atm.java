package com.pajehyk.atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Class for computing number of different combinations of given banknotes which in sum gives 
 * certain number.
 */
public class Atm {
    static long givenSum; 
    static long numberOfBanknotes;
    static ArrayList<Long> banknotesValues = new ArrayList<>(); // Banknotes values
    static int numberOfAnswers = 0; 
    static ArrayList<ArrayList<Long>> answerList = new ArrayList<>();

    /**
     * Main method of Atm class, scans for input data and calls atmCompute() method.
     *
     * @param args command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        readInputData(System.in);
        atmCompute(true, 0, 0, new ArrayList<>());
        writeOutputData();
    }

    /**
     * Method that reads input data and stores it in givenSum, 
     * numberOfBanknotes and banknotesValues variables.
     * 
     * @param fis InputStream that BufferedReader reads from
     */
    public static void readInputData(InputStream fis) {
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        try {
            String st = in.readLine();
            givenSum = Long.parseLong(st);
            st = in.readLine();
            int ind = 0;
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == ' ') {
                    long addedElement = Long.parseLong(st.substring(ind, i));
                    if (!banknotesValues.contains(addedElement)) {
                        banknotesValues.add(addedElement);
                        ind = i + 1;
                        numberOfBanknotes++;
                    }
                }
            }
            long addedElement = Long.parseLong(st.substring(ind, st.length()));
            if (!banknotesValues.contains(addedElement)) {
                banknotesValues.add(addedElement);
                numberOfBanknotes++;
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Method that write output data into OutputStream.
     *
     */
    public static void writeOutputData() {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write(answerList.toString());
            out.flush();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
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
    public static void atmCompute(boolean firstRun, long recursiveSum, 
        int currentBanknote, ArrayList<Long> takenBanknotes) {
        if (firstRun) {
            answerList.add(new ArrayList<>());
            answerList.get(0).add(0L);
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
