package com.pajehyk.atm;

import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        givenSum = scan.nextInt();
        numberOfBanknotes = scan.nextInt();
        for (int i = 0; i < numberOfBanknotes; i++) {
            banknotesValues.add(scan.nextInt());
        }
       
        atmCompute(true, 0, 0, new ArrayList<>());
        System.out.println(answerList);
        scan.close();
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
