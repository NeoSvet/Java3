package ru.neosvet.algoritmy4;

import ru.neosvet.algoritmy4.list.StackList;

public class MyStack<T> {
    StackList<T> list;

    public MyStack() {
        list = new StackList<>();
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        return list.delete();
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
