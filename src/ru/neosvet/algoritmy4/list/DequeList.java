package ru.neosvet.algoritmy4.list;

public class DequeList<T> {
    public static class ItemList<T> {
        private T link;
        private ItemList<T> previous, next;

        public ItemList(T link) {
            this.link = link;
        }

        public T getValue() {
            return link;
        }

        public ItemList<T> getPrevious() {
            return previous;
        }

        public void setPrevious(ItemList<T> previous) {
            this.previous = previous;
        }

        public ItemList<T> getNext() {
            return next;
        }

        public void setNext(ItemList<T> next) {
            this.next = next;
        }
    }

    private ItemList<T> first, last;

    public DequeList() {
        last = null;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addToStart(T value) {
        ItemList<T> item = new ItemList<>(value);
        item.setNext(first);
        if (first != null)
            first.setPrevious(item);
        if (last == null)
            last = item;
        first = item;
    }

    public void addToEnd(T value) {
        ItemList<T> item = new ItemList<>(value);
        item.setPrevious(last);
        if (last == null)
            first = item;
        else
            last.setNext(item);
        last = item;
    }

    public T deleteFromStart() {
        ItemList<T> item = first;
        if (last.equals(first)) {
            last = null;
            first = null;
        } else
            first = first.getNext();
        return item.getValue();
    }

    public T deleteFromEnd() {
        ItemList<T> item = last;
        if (last.equals(first)) {
            last = null;
            first = null;
        } else
            last = last.getPrevious();
        return item.getValue();
    }
}
