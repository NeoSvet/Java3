package ru.neosvet.algoritmy4;

import java.util.LinkedList;

public class LinkedQueue<T> {
    private LinkedList<T> list;

    public LinkedQueue() {
        list = new LinkedList<>();
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        return list.pop();
    }

    public T peek() {
        return list.peekFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
