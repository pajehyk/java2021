package com.pajehyk.atm;

import java.util.Scanner;
/**
 * Please put here your ATM code.
 */
public class Atm {
    private static int givenSum, numberOfBanknotes;
    private static int[] banknotesValues; // Banknotes values
    private static int[] banknotesMaxNumber; // max number of each banknote
    private static int[] banknotesMaxNumberTemp;
    private static int numberOfAnswers = 0; 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        givenSum = scan.nextInt();
        numberOfBanknotes = scan.nextInt();
        banknotesValues = new int[numberOfBanknotes];
        banknotesMaxNumber = new int[numberOfBanknotes];
        banknotesMaxNumberTemp = new int[numberOfBanknotes];
        for (int i=0; i<numberOfBanknotes; i++) {
            banknotesValues[i] = scan.nextInt();
            banknotesMaxNumber[i] = givenSum / banknotesValues[i];
            banknotesMaxNumberTemp[i] = banknotesMaxNumber[i];
        }

        AtmCompute(0, 0);        
        System.out.println("answer is " + numberOfAnswers);
        scan.close();
    }

    private static void AtmCompute(int k, int sum) {
        if (k >= numberOfBanknotes) {
            if (sum == givenSum) {
                numberOfAnswers++;
                for (int i=0; i<numberOfBanknotes; i++) {
                    for (int j=0; j<banknotesMaxNumberTemp[i]; j++) {
                        System.out.print(banknotesValues[i] + " ");
                    }
                }
                System.out.println();
            }
            return;
        }
        while (banknotesMaxNumberTemp[k] >= 0) {
            AtmCompute(k+1, sum + banknotesValues[k]*banknotesMaxNumberTemp[k]);

            banknotesMaxNumberTemp[k]--;
            for (int i=k+1; i<numberOfBanknotes; i++) {
                banknotesMaxNumberTemp[i] = banknotesMaxNumber[i];
            }
        }
    }
}
