package ru.neosvet.algoritmy4.list;

public class QueueList<T> {
    private ItemList<T> first, last;

    public QueueList() {
        last = null;
    }

    public T getFirst() {
        return first.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T value) {
        ItemList<T> item = new ItemList<>(value);
        if (last == null)
            first = item;
        else
            last.setNext(item);
        last = item;
    }

    public T delete() {
        ItemList<T> item = first;
        first = first.getNext();
        return item.getValue();
    }
}
