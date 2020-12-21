package ru.neosvet.lesson4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.start();

        Task2 task2 = new Task2();
        try {
            task2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
