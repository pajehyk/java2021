package com.mblagov.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

/**
 * Cat tester.
 */
public class AnimalTest {

    @Test
    public void testCatMessages() {
        Cat cat = new Cat();
        assertEquals("Meow", cat.getMessage());
    }

    @Test
    public void testDogMessages() {
        Dog dog = new Dog();
        assertEquals("Woof", dog.getMessage());
    }

    @Test
    public void testSayHello() {
        Animal animal = new Dog();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        animal.sayHello(out);
        assertEquals("Woof", out.toString().trim());
    }

}
