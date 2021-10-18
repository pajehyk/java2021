package com.pajehyk.atm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class AtmTest {
    @Test
    public  void testGetAnswer() {
        Atm.givenSum = 5;
        Atm.numberOfBanknotes = 2;
        Atm.banknotesValues.add(3L);
        Atm.banknotesValues.add(1L);
        Atm.atmCompute(true, 0, 0, new ArrayList<>());
        ArrayList<ArrayList<Integer>> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.get(0).add(2);
        expectedArrayList.get(1).add(3);
        expectedArrayList.get(1).add(1);
        expectedArrayList.get(1).add(1);
        expectedArrayList.get(2).add(1);
        expectedArrayList.get(2).add(1);
        expectedArrayList.get(2).add(1);
        expectedArrayList.get(2).add(1);
        expectedArrayList.get(2).add(1);

        assertTrue(expectedArrayList.equals(Atm.answerList));
    }
}