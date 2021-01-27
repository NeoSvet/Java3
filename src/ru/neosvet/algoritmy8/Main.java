package ru.neosvet.algoritmy8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 50;

        int[] mArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(800) + 100;
        }

        System.out.println("Задание 8.4");
        HashTable table = new HashTable(size * 2, HashTable.Mode.SAMPLE);
        for (int i = 0; i < size; i++) {
            table.insert(mArray[i]);
        }
        table.display();

        System.out.println("Задание 8.5");
        table = new HashTable(size * 2, HashTable.Mode.DOUBLE_HASH);
        for (int i = 0; i < size; i++) {
            table.insert(mArray[i]);
        }
        table.display();
    }
}
