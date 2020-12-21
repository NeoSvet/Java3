package ru.neosvet.lesson4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    private static final int LIMIT = 3;
    private int countFinished = 0;
    private BufferedWriter bw;

    public void start() throws IOException {
        File file = new File("src/ru/neosvet/lesson4/task2.txt");
        bw = new BufferedWriter(new FileWriter(file));

        Thread t1 = new Thread(() -> {
            startProcess("thread1");
            increaseFinished();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            startProcess("thread2");
            increaseFinished();
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            startProcess("thread3");
            increaseFinished();
        });
        t3.start();
    }

    private void startProcess(String data) {
        for (int i = 0; i < 10; i++) {
            printData(data);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printData(String data) {
        try {
            bw.write(data);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void increaseFinished() {
        countFinished++;
        if (countFinished == LIMIT) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nTask2 finished");
        }
    }
}

