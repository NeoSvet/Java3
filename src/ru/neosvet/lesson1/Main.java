package ru.neosvet.lesson1;

public class Main {

    public static void main(String[] args) {
        ArrayAdv<String> advString = new ArrayAdv<>(5);
        advString.add("A");
        advString.add("B");
        advString.add("C");
        advString.add("D");
        advString.add("E");

        advString.print();
    }

}
