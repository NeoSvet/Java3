package ru.neosvet.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayAdv<String> advString = new ArrayAdv<>(5);
        advString.add("A");
        advString.add("B");
        advString.add("C");
        advString.add("D");
        advString.add("E");

        advString.print();
        System.out.println("Task 1:");
        advString.change(2, 4);
        advString.change(1, 3);
        advString.print();

        System.out.println("Task 2:");
        ArrayList<String> list = advString.toArrayList();
        for (String item : list) {
            System.out.println(item);
        }
    }

}
