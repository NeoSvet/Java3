package ru.neosvet.lesson7;

public class Main {
    public static void main(String[] args) {
        try {
            start("ru.neosvet.lesson7.Test1");
            start(Test2.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void start(String className) throws Exception {
        start(Class.forName(className));
    }

    private static void start(Class<?> classType) throws Exception {
        Tester tester = new Tester(classType);
        tester.checkMethods();
        tester.start();
    }
}
