package ru.neosvet.lesson1.fruit;

import java.util.ArrayList;

public class Box<F extends IFruit> {
    private ArrayList<F> content = new ArrayList<>();

    public void put(F fruit) {
        content.add(fruit);
    }

    public int getSize() {
        return content.size();
    }

    public float getTotalWeight() {
        float sum = 0f;
        for (F item : content) {
            sum += item.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> box) {
        return getTotalWeight() == box.getTotalWeight();
    }

    public F take() {
        if (content.size() == 0)
            return null;
        F item = content.get(0);
        content.remove(0);
        return item;
    }
}
