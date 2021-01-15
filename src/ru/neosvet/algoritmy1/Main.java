package ru.neosvet.algoritmy1;

public class Main {

    private static Object obj; //ссылочный тип
    private static int number; //примитивный тип
    private static Cat cat; //свой класс

    public static void main(String[] args) {
        obj = new Object();
        number = 10;
        cat = new Cat("Борис", 7);

        print();
        launchCompare();
    }

    private static void launchCompare() {
        long start = System.nanoTime();

        System.out.print("obj и number: ");
        if (obj.equals(number))
            System.out.println("равны");
        else
            System.out.println("не равны");

        System.out.print("obj и cat: ");
        if (obj.equals(cat))
            System.out.println("равны");
        else
            System.out.println("не равны");

        System.out.print("cat и number: ");
        if (cat.equals(number))
            System.out.println("равны");
        else
            System.out.println("не равны");

        System.out.println("Время выполнения: " + (System.nanoTime() - start));
    }

    private static void print() {
        System.out.println(obj.toString());
        System.out.println(number);
        System.out.println(cat.toString());
    }
}
