package ru.neosvet.algoritmy6;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 6.2-6.5");

        Tree<Person> tree = new Tree<>();

        tree.insert(new Person(1, "Ivan", 20));
        tree.insert(new Person(5, "Oleg", 23));
        tree.insert(new Person(4, "Marina", 26));
        tree.insert(new Person(3, "Yura", 30));
        tree.insert(new Person(2, "Olga", 22));

        tree.display(Tree.Order.IN);

        System.out.println("Min:");
        long time1 = System.nanoTime();
        tree.foundMin().display();
        long time2 = System.nanoTime();
        System.out.println("time: " + (time2 - time1));
        System.out.println("Max:");
        time1 = System.nanoTime();
        tree.foundMax().display();
        time2 = System.nanoTime();
        System.out.println("time: " + (time2 - time1));
        System.out.println("Found id=3:");
        time1 = System.nanoTime();
        tree.find(3).display();
        time2 = System.nanoTime();
        System.out.println("time: " + (time2 - time1));
        System.out.println("Delete id=1.");
        time1 = System.nanoTime();
        tree.delete(1);
        time2 = System.nanoTime();
        System.out.println("time: " + (time2 - time1));

        tree.display(Tree.Order.IN);


        System.out.println("Задание 6.6");
        int[] mArray = new int[50];
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(mArray));
        int[] mArray2 = Arrays.copyOf(mArray, mArray.length);

        System.out.println("Sort by Heap");
        Heap heap = new Heap(mArray);
        time1 = System.nanoTime();
        heap.sort();
        time2 = System.nanoTime();
        System.out.println(Arrays.toString(heap.getArray()));
        System.out.println("time: " + (time2 - time1));

        System.out.println("Sort by Arrays");
        time1 = System.nanoTime();
        Arrays.sort(mArray2);
        time2 = System.nanoTime();
        System.out.println(Arrays.toString(mArray2));
        System.out.println("time for sort: " + (time2 - time1));
    }
}
