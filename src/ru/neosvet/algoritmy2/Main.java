package ru.neosvet.algoritmy2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //заполнение массива:
        int[] mArray = new int[5000];
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }

        System.out.println("Задание 2.1:");
        long time1 = System.nanoTime();
        System.out.println(Arrays.toString(mArray));
        long time2 = System.nanoTime();
        System.out.println("time for toString: " + (time2 - time1));

        int[] mArray2 = Arrays.copyOf(mArray, mArray.length);
        time1 = System.nanoTime();
        System.out.println("time for copyOf: " + (time1 - time2));

        System.out.println(Arrays.equals(mArray, mArray2));
        time2 = System.nanoTime();
        System.out.println("time for equals: " + (time2 - time1));

        System.out.println("Задание 2.2:");
        int key = random.nextInt(15);
        System.out.println("Search for " + key);
        System.out.println("Array:");
        System.out.println(Arrays.toString(mArray));

        System.out.println("Линейный поиск");
        time1 = System.nanoTime();
        int k = 0;
        for (int i = 0; i < mArray.length; i++) {
            if (mArray[i] == key) {
                k++;
                //System.out.println("Found on " + i);
            }
        }
        System.out.println("Found count: " + k);
        time2 = System.nanoTime();
        System.out.println("time for line search: " + (time2 - time1));

        System.out.println("Sorted array:");
        Arrays.sort(mArray);
        System.out.println(Arrays.toString(mArray));
        time1 = System.nanoTime();
        System.out.println("time for sort: " + (time1 - time2));

        System.out.println("Двоичный поиск");
        int a = 0;
        int b = mArray.length - 1;
        int m;

        while (a <= b) {
            m = (a + b) / 2;

            if (mArray[m] == key) {
                findAll(mArray, m, key); //линейный поиск находит все совпадения
                //и я сделал чтобы и двоичный тоже всё находил.
                break;
            } else if (mArray[m] < key) {
                a = m + 1;
            } else if (mArray[m] > key) {
                b = m - 1;
            }
        }

        time2 = System.nanoTime();
        System.out.println("time for binary search: " + (time2 - time1));

        System.out.println("Задание 2.3:");
        mArray = new int[400];
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }
        mArray2 = Arrays.copyOf(mArray, mArray.length);

        time1 = System.nanoTime();
        Arrays.sort(mArray);
        time2 = System.nanoTime();
        System.out.println("time for sort: " + (time2 - time1));
        System.out.println(Arrays.toString(mArray));

        System.out.println("Задание 2.4:");
        mArray = Arrays.copyOf(mArray2, mArray.length);
        time1 = System.nanoTime();
        int buff;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < mArray.length - 1; i++) {
                if (mArray[i] > mArray[i + 1]) {
                    sorted = false;
                    buff = mArray[i];
                    mArray[i] = mArray[i + 1];
                    mArray[i + 1] = buff;
                }
            }
        }
        time2 = System.nanoTime();
        System.out.println("time for bubble sort: " + (time2 - time1));
        System.out.println(Arrays.toString(mArray));

        System.out.println("Задание 2.5:");
        mArray = Arrays.copyOf(mArray2, mArray.length);
        time1 = System.nanoTime();
        int n;
        for (int i = 0; i < mArray.length - 1; i++) {
            n = i;
            for (int j = i + 1; j < mArray.length; j++) {
                if (mArray[j] < mArray[n])
                    n = j;
            }
            if (n != i) {
                buff = mArray[i];
                mArray[i] = mArray[n];
                mArray[n] = buff;
            }
        }
        time2 = System.nanoTime();
        System.out.println("time for select sort: " + (time2 - time1));
        System.out.println(Arrays.toString(mArray));

        System.out.println("Задание 2.6:");
        mArray = Arrays.copyOf(mArray2, mArray.length);
        time1 = System.nanoTime();
        for (int i = 1; i < mArray.length; i++) {
            buff = mArray[i];
            n = i;
            while (n > 0 && mArray[n - 1] >= buff) {
                mArray[n] = mArray[n - 1];
                --n;
            }
            mArray[n] = buff;
        }
        time2 = System.nanoTime();
        System.out.println("time for paste sort: " + (time2 - time1));
        System.out.println(Arrays.toString(mArray));
    }

    private static void findAll(int[] m, int s, int key) {
        //System.out.println("Found on " + s);
        int k = 1;
        int i = s - 1;
        while (i > -1 && m[i] == key) {
            //System.out.println("Found on " + i);
            k++;
            i--;
        }
        i = s + 1;
        while (i < m.length && m[i] == key) {
            //System.out.println("Found on " + i);
            k++;
            i++;
        }
        System.out.println("Found count: " + k);
    }
}
