package ru.neosvet.algoritmy3;

class ItemOneList<T> {
    private T link;
    private ItemOneList<T> next;

    public ItemOneList(T link) {
        this.link = link;
    }

    public T getValue() {
        return link;
    }

    public ItemOneList<T> getNext() {
        return next;
    }

    public void setNext(ItemOneList<T> next) {
        this.next = next;
    }
}


public class OneLinkList<T> {
    private ItemOneList<T> first;

    public OneLinkList() {
        first = null;
    }

    public ItemOneList<T> getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void add(T value) {
        ItemOneList<T> item = new ItemOneList<>(value);
        item.setNext(first);
        this.first = item;
    }

    public ItemOneList<T> delete() {
        ItemOneList<T> item = first;
        first = first.getNext();
        return item;
    }

    public void display() {
        ItemOneList<T> item = first;
        while (item != null) {
            System.out.println(item.getValue());
            item = item.getNext();
        }
    }

    public T find(T search) {
        ItemOneList<T> item = first;
        while (item != null) {
            if (item.getValue().equals(search)) {
                return search;
            }
            item = item.getNext();
        }
        return null;
    }
}
