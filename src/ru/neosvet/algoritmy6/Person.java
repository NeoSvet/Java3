package ru.neosvet.algoritmy6;

public class Person implements HasID {
    private String name;
    private int id, age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Age: " + age;
    }

    @Override
    public int getId() {
        return id;
    }
}
