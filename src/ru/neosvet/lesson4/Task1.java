package ru.neosvet.lesson4;

public class Task1 {
    private Letter curLetter = Letter.C;
    private Object obj = new Object();

    public void start() {
        Thread t1 = new Thread(() -> {
            printLetter(Letter.C, Letter.A);
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            printLetter(Letter.A, Letter.B);
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            printLetter(Letter.B, Letter.C);
        });
        t3.start();
    }

    private void printLetter(Letter prevLetter, Letter newLetter) {
        synchronized (obj) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (curLetter != prevLetter)
                        obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                curLetter = newLetter;
                System.out.print(curLetter.toString());
                obj.notifyAll(); //notifyAll обязательно нужен только для 3 потока, в остальных можно просто notify
            }
        }
    }
}


enum Letter {
    A('A'), B('B'), C('C');

    private char c;

    Letter(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}
