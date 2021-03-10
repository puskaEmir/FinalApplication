package com.academy.finalacademy387;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. prosti tipovi podataka
 * 2. složeni ili objektni
 * 2.1 sirovi objektni tipovi podataka
 * 2.2 parametrizirani objektni tipovi podataka
 */
public class Person {

    private String name;
    private String surname;

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "";
        List list = new ArrayList();


        Box rawBox = new Box();
        Box<Integer> box1 = new Box<>();
    }

    static class Box<T extends Number> {
        private T field;
    }
}
