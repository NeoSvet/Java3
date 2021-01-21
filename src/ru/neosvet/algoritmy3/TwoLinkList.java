package ru.neosvet.algoritmy3;

class ItemTwoList<T> {
    private T link;
    private ItemTwoList<T> next, previous;

    public ItemTwoList(T link) {
        this.link = link;
    }

    public T getValue() {
        return link;
    }

    public boolean hasPrevious() {
        return (previous != null);
    }

    public boolean hasNext() {
        return (next != null);
    }

    public ItemTwoList<T> getNext() {
        return next;
    }

    public void setNext(ItemTwoList<T> next) {
        this.next = next;
    }

    public ItemTwoList<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ItemTwoList<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return link.toString();
    }
}


public class TwoLinkList<T> {
    private ItemTwoList<T> first, last;

    public TwoLinkList() {
        first = null;
    }

    public ItemTwoList<T> getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void add(T value) {
        ItemTwoList<T> item = new ItemTwoList<>(value);
        if (first != null) {
            item.setPrevious(last);
            last.setNext(item);
        } else {
            first = item;
        }
        last = item;
    }

    public ItemTwoList<T> deleteLast() {
        if (last == null)
            return null;

        ItemTwoList<T> item = last;
        if (last.hasPrevious()) {
            last = last.getPrevious();
        } else {
            first = null;
            last = null;
        }

        return item;
    }

    public void display() {
        ItemTwoList<T> item = first;
        while (item != null) {
            System.out.println(item.getValue());
            item = item.getNext();
        }
    }

    public T find(T search) {
        ItemTwoList<T> item = first;
        while (item != null) {
            if (item.getValue().equals(search)) {
                return search;
            }
            item = item.getNext();
        }
        return null;
    }
}