package ru.neosvet.algoritmy4;

import ru.neosvet.algoritmy4.list.PriorityList;

public class MyPriorityQueue<T> {
    PriorityList<T> list;

    public MyPriorityQueue() {
        list = new PriorityList<>();
    }

    public void push(T value, int key) {
        list.add(value, key);
    }

    public T pop() {
        return list.delete();
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
