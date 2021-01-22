package ru.neosvet.algoritmy4;

import ru.neosvet.algoritmy4.list.DequeList;

public class MyDeque<T> {
    DequeList<T> list;

    public MyDeque() {
        list = new DequeList<>();
    }

    public void addBack(T value) {
        list.addToEnd(value);
    }

    public void addFront(T value) {
        list.addToStart(value);
    }

    public T popBack() {
        return list.deleteFromEnd();
    }

    public T popFront() {
        return list.deleteFromStart();
    }

    public T peekBack() {
        return list.getLast();
    }

    public T peekFront() {
        return list.getFirst();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
