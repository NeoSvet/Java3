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

        Mfu mfu = new Mfu();
        /*  mfu.start();
        к сожалению, задумка читать команды из консоли
        и печатать туда же прогресс не оправдала себя,
        т.к. не получается ввести команду целиком */
        mfu.print(10);
        mfu.scan(30);
        mfu.print(10);
    }
}
