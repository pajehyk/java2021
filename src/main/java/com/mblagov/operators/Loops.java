package com.mblagov.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Loops samples.
 */
public class Loops {

    /**
     * A main method for loop samples.
     *
     * @param args an argument array to be used in the method
     */
    public static void main(String[] args) {
        System.out.println("===== for loop =====");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("===== while loop =====");
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("===== do while loop =====");
        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 10);

        System.out.println("===== foreach =====");
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            list.add(j);
        }
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
