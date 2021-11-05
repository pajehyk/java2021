package com.pajehyk.atm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class AtmTest {
    @Test
    public void testGetAnswer() {
        try {
            Atm.readInputData(new FileInputStream(new File("src/test/java/com/pajehyk/atm/test1.in")));
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        Atm.atmCompute(true, 0, 0, new ArrayList<>());
        ArrayList<ArrayList<Long>> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.add(new ArrayList<>());
        expectedArrayList.get(0).add(2L);
        expectedArrayList.get(1).add(3L);
        expectedArrayList.get(1).add(1L);
        expectedArrayList.get(1).add(1L);
        expectedArrayList.get(2).add(1L);
        expectedArrayList.get(2).add(1L);
        expectedArrayList.get(2).add(1L);
        expectedArrayList.get(2).add(1L);
        expectedArrayList.get(2).add(1L);

        assertTrue(expectedArrayList.equals(Atm.answerList));
    }
}