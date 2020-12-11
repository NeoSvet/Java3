package ru.neosvet.lesson1.fruit;

import java.util.Random;

public class Main {
    private static final int MAX = 10;

    public static void main(String[] args) {
        Random random = new Random();

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < random.nextInt(MAX); i++) {
            appleBox.put(new Apple());
        }
        System.out.println("Total fruits in apple box: " + appleBox.getSize());

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < random.nextInt(MAX); i++) {
            orangeBox.put(new Orange());
        }
        System.out.println("Total fruits in orange box: " + orangeBox.getSize());

        System.out.println("Compare boxes: " + appleBox.compare(orangeBox));

        if (appleBox.getSize() < 2) {
            System.out.println("Nothing to take");
            return;
        }
        System.out.println("Take half of apple box to new box.");
        int count_take = appleBox.getSize() / 2;
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < count_take; i++) {
            appleBox2.put(appleBox.take());
        }
        System.out.println("Total fruits in first apple box: " + appleBox.getSize());
        System.out.println("Total fruits in second apple box: " + appleBox2.getSize());
    }
}
