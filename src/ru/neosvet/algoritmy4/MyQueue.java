package ru.neosvet.algoritmy4;

import ru.neosvet.algoritmy4.list.QueueList;

public class MyQueue<T> {
    QueueList<T> list;

    public MyQueue() {
        list = new QueueList<>();
    }

    public void push(T value) {
        list.add(value);
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
