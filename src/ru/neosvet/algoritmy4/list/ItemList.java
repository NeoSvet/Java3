package ru.neosvet.algoritmy4.list;

public class ItemList<T> {
    private T link;
    private ItemList<T> next;

    public ItemList(T link) {
        this.link = link;
    }

    public T getValue() {
        return link;
    }

    public ItemList<T> getNext() {
        return next;
    }

    public void setNext(ItemList<T> next) {
        this.next = next;
    }
}
