package ru.neosvet.lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        System.out.println(Arrays.toString(afterLastFour(a)));

        System.out.println("checkNumbers: " + checkNumbers(a));
    }

    public static boolean checkNumbers(int[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] == 1 || m[i] == 4)
                return true;
        }
        return false;
    }

    public static int[] afterLastFour(int[] m) {
        int i;
        for (i = m.length - 1; i > -1; i--) {
            if (m[i] == 4)
                break;
        }
        if (i == -1) {
            throw new RuntimeException("Array don't have four.");
        }
        i++;
        int[] r = new int[m.length - i];
        for (int j = i; j < m.length; j++) {
            r[j - i] = m[j];
        }
        return r;
    }
}
