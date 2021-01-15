package ru.neosvet.algoritmy1;

public class Cat {
    private String nick;
    private int age;

    public Cat(String nick, int age) {
        this.nick = nick;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Кот " + nick + " возрастом " + age;
    }
}
