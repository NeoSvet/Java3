package ru.neosvet.lesson4;

import java.util.Scanner;

public class Mfu {
    private final int TIME = 50;
    private Object monitorPrint = new Object();
    private Object monitorScan = new Object();
    private Operation operation = Operation.NONE;
    private int numberOperation = 1;
    private int numberPrint;
    private int numberScan;

    public void start() {
        System.out.println("МФУ запущено");
        System.out.println("print 5 - для печати 5");
        System.out.println("scan 3 - для сканирования 3");
        System.out.println("exit - для выхода");
        Scanner scan = new Scanner(System.in);
        String s;
        int k;
        while (true) {
            s = scan.nextLine();
            if (s.equals("exit")) {
                System.out.println("МФУ завершено");
                break;
            }
            if (s.startsWith("print")) {
                k = getCount(s);
                if (k < 1)
                    continue;
                print(k);
            }
            if (s.startsWith("scan")) {
                k = getCount(s);
                if (k < 1)
                    continue;
                scan(k);
            }
        }
    }

    private int getCount(String s) {
        try {
            s = s.substring(s.indexOf(" ") + 1);
            return Integer.parseInt(s);
        } catch (Exception e) {
        }
        return -1;
    }

    public void print(int count) {
        Thread t = new Thread(() -> {
            synchronized (monitorPrint) {
                numberPrint = numberOperation;
                numberOperation++;
                for (int i = 1; i <= count; i++) {
                    doOperation(Operation.PRINT, i);
                }
                finishOperation();
            }
        });
        t.start();
    }

    public void scan(int count) {
        Thread t = new Thread(() -> {
            synchronized (monitorScan) {
                numberScan = numberOperation;
                numberOperation++;
                for (int i = 1; i <= count; i++) {
                    doOperation(Operation.SCAN, i);
                }
                finishOperation();
            }
        });
        t.start();
    }

    private void finishOperation() {
        synchronized (operation) {
            operation = Operation.NONE;
            System.out.println();
        }
    }

    private void doOperation(Operation op, int value) {
        synchronized (operation) {
            if (operation != op) {
                if (operation != Operation.NONE)
                    System.out.println();
                operation = op;
                switch (operation) {
                    case PRINT:
                        System.out.print("Отпечатано (#" + numberPrint + ") ");
                        break;
                    case SCAN:
                        System.out.print("Отсканировано (#" + numberScan + ") ");
                        break;
                }
            }
            System.out.print(value + " ");
        }

        try {
            Thread.sleep(TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

enum Operation {
    NONE, SCAN, PRINT
}
