package ru.neosvet.algoritmy7;

import java.util.LinkedList;
import java.util.List;

public class Level {
    private final List<Integer> list;
    private int number = 0;

    public Level() {
        list = new LinkedList<>();
    }

    public void upLevel() {
        list.clear();
        number++;
    }

    public void addTenant(int index) {
        list.add(index);
    }

    public boolean contains(int index) {
        return list.contains(index);
    }

    public void closeIfNeed() {
        if (number > 0)
            System.out.println("End level " + number);
    }

    public void openIfNeed() {
        if (list.size() == 0)
            System.out.println("Start level " + number);
    }
}
