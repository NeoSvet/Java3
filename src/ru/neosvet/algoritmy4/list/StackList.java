package ru.neosvet.algoritmy4.list;

public class StackList<T> {
    private ItemList<T> last;

    public StackList() {
        last = null;
    }

    public T getLast() {
        return last.getValue();
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void add(T value) {
        ItemList<T> item = new ItemList<>(value);
        item.setNext(last);
        last = item;
    }

    public T delete() {
        ItemList<T> item = last;
        last = last.getNext();
        return item.getValue();
    }
}
