package ru.neosvet.algoritmy4;

import java.util.LinkedList;

public class LinkedStack<T> {
    private LinkedList<T> list;

    public LinkedStack() {
        list = new LinkedList<>();
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        try {
            return list.removeLast();
        } catch(Exception e) {
            return null;
        }
    }

    public T peek() {
        return list.peekLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
