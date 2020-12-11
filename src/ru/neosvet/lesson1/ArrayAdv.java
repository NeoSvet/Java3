package ru.neosvet.lesson1;

public class ArrayAdv<T> {
    private T[] data;
    private int currentIndex = -1;

    public ArrayAdv(int size) {
        this.data = (T[]) new Object[size];
        currentIndex = 0;
    }

    public void add(T item) {
        if (currentIndex < data.length)
            data[currentIndex++] = item;
    }

    public void set(int index, T item) {
        if (index > -1 && index < data.length)
            data[index] = item;
    }

    public T get(int index) {
        return data[index];
    }
}
