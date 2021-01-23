package ru.neosvet.algoritmy5;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 5.2");
        //infiniteRecursion(0);
        recursionWithCondition(0);
        System.out.println();

        System.out.println("Задание 5.4");
        long time1 = System.nanoTime();
        int n = 0;
        while (n < 101) {
            System.out.print(n++);
            System.out.print(", ");
        }
        long time2 = System.nanoTime();
        System.out.println();
        System.out.println("While time: " + (time2 - time1));

        time1 = System.nanoTime();
        for (int i = 0; i < 101; i++) {
            System.out.print(i);
            System.out.print(", ");
        }
        time2 = System.nanoTime();
        System.out.println();
        System.out.println("For time: " + (time2 - time1));

        time1 = System.nanoTime();
        recursionWithCondition(0);
        time2 = System.nanoTime();
        System.out.println();
        System.out.println("Recursion time: " + (time2 - time1));

        System.out.println("Задание 5.5");
        int[] mArray = getArray();
        Arrays.sort(mArray);
        System.out.println(Arrays.toString(mArray));

        int key = 5;
        System.out.println("Search for " + key + ":");
        time1 = System.nanoTime();
        int result = recursionSearch(mArray, key, 0, mArray.length - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found on " + result);
        time2 = System.nanoTime();
        System.out.println("recursionSearch time: " + (time2 - time1));
        time1 = System.nanoTime();
        result = binarySearch(mArray, key);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found on " + result);
        time2 = System.nanoTime();
        System.out.println("binarySearch time: " + (time2 - time1));

        System.out.println("Задание 5.6");
        mArray = getArray();
        int[] mArray2 = Arrays.copyOf(mArray, mArray.length);
        time1 = System.nanoTime();
        Arrays.sort(mArray);
        System.out.println(Arrays.toString(mArray));
        time2 = System.nanoTime();
        System.out.println("fast sort time: " + (time2 - time1));

        time1 = System.nanoTime();
        System.out.println(Arrays.toString(mergeSort(mArray2)));
        time2 = System.nanoTime();
        System.out.println("mergeSort time: " + (time2 - time1));
    }

    private static int[] mergeSort(int[] m) {
        int len = m.length;
        if (len < 2) return m;

        int half = len / 2;
        int[] a = mergeSort(Arrays.copyOfRange(m, 0, half));
        int[] b = mergeSort(Arrays.copyOfRange(m, half, len));

        int[] r = new int[len];
        int iA = 0, iB = 0;

        for (int i = 0; i < len; i++) {
            r[i] = a[iA] < b[iB] ? a[iA++] : b[iB++];
            if (iA == a.length) {
                System.arraycopy(b, iB, r, ++i, b.length - iB);
                break;
            }
            if (iB == b.length) {
                System.arraycopy(a, iA, r, ++i, a.length - iA);
                break;
            }
        }
        return r;
    }

    private static int[] getArray() {
        int[] mArray = new int[100];
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }
        return mArray;
    }

    private static int binarySearch(int[] m, int key) {
        int a = 0;
        int b = m.length - 1;
        int i;

        while (a <= b) {
            i = (a + b) / 2;

            if (m[i] == key) {
                return i;
            } else if (m[i] < key) {
                a = i + 1;
            } else if (m[i] > key) {
                b = i - 1;
            }
        }
        return -1;
    }

    private static int recursionSearch(int[] m, int key, int start, int end) {
        if (start >= end)
            return -1;

        int i = (start + end) / 2;

        if (m[i] == key)
            return i;

        if (m[i] < key)
            return recursionSearch(m, key, start + 1, end);
        else
            return recursionSearch(m, key, start, end - 1);
    }

    private static void recursionWithCondition(int i) {
        System.out.print(i);
        System.out.print(", ");
        if (i == 100)
            return;
        recursionWithCondition(i + 1);
    }

    private static void infiniteRecursion(int i) {
        System.out.print(i);
        System.out.print(", ");
        infiniteRecursion(i + 1);
    }
}
