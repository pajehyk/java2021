package com.pajehyk.atm;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Please put here your ATM code.
 */
public class Atm {
    static int givenSum, numberOfBanknotes;
    static ArrayList<Integer> banknotesValues = new ArrayList<>(); // Banknotes values
    static int numberOfAnswers = 0; 
    static ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        givenSum = scan.nextInt();
        numberOfBanknotes = scan.nextInt();
        for (int i=0; i<numberOfBanknotes; i++) {
            banknotesValues.add(scan.nextInt());
        }
       
        atmCompute(true, 0, 0, new ArrayList<>());
        System.out.println(answerList);
        scan.close();
    }

    public static void atmCompute(boolean firstRun, int recursiveSum, int currentBanknote, ArrayList<Integer> takenBanknotes) {
        if (firstRun) {
            answerList.add(new ArrayList<>());
            answerList.get(0).add(0);
        }
        if (recursiveSum >= givenSum || currentBanknote >= numberOfBanknotes) {
            if (recursiveSum == givenSum) {
                answerList.add(new ArrayList<>(takenBanknotes));
                answerList.get(0).set(0, answerList.get(0).get(0)+1);
            }
        } else {
            takenBanknotes.add(banknotesValues.get(currentBanknote));
            atmCompute(false, recursiveSum + banknotesValues.get(currentBanknote), currentBanknote, takenBanknotes);
            takenBanknotes.remove(takenBanknotes.size()-1);
            atmCompute(false, recursiveSum, currentBanknote+1, takenBanknotes);
        }
    }
}
