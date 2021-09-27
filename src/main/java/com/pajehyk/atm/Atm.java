package com.mblagov.atm;

import java.util.Scanner;
/**
 * Please put here your ATM code.
 */
public class Atm {
    private static int n, m;
    private static int[] arr; // Banknotes values
    private static int[] arr_max; // max number of each banknote
    private static int[] arr_edit;
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[m];
        arr_max = new int[m];
        arr_edit = new int[m];
        for (int i=0; i<m; i++) {
            arr[i] = scan.nextInt();
            arr_max[i] = n / arr[i];
            arr_edit[i] = arr_max[i];
        }

        AtmCompute(0, 0);        
        System.out.println("answer is " + ans);
        scan.close();
    }

    private static void AtmCompute(int k, int sum) {
        if (k >= m) {
            if (sum == n) {
                ans++;
                for (int i=0; i<m; i++) {
                    for (int j=0; j<arr_edit[i]; j++) {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.println();
            }
            return;
        }
        while (arr_edit[k] >= 0) {
            AtmCompute(k+1, sum + arr[k]*arr_edit[k]);

            arr_edit[k]--;
            for (int i=k+1; i<m; i++) {
                arr_edit[i] = arr_max[i];
            }
        }
    }
}
