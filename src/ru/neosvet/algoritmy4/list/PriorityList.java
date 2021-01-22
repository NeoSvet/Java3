package ru.neosvet.algoritmy4.list;

public class PriorityList<T> {
    public static class ItemList<T> {
        private T link;
        private int key;
        private ItemList<T> previous, next;

        public ItemList(T link, int key) {
            this.link = link;
            this.key = key;
        }

        public int getKey() {
            return key;
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

    private ItemList<T> first;

    public PriorityList() {
        first = null;
    }

    public T getFirst() {
        return first.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T value, int key) {
        ItemList<T> item = new ItemList<>(value, key);
        //когда список пуст:
        if (first == null) {
            first = item;
            return;
        }
        //когда у первого элемента приоритет ниже, чем у нового
        if (first.getKey() > key) {
            item.setNext(first);
            first.setPrevious(item);
            first = item;
            return;
        }
        //когда у первого элемента приоритет выше, чем у нового, а последующих элементов нет
        ItemList<T> cur = first.getNext();
        if (cur == null) {
            first.setNext(item);
            item.setPrevious(first);
            return;
        }
        //когда у первого элемента приоритет выше, чем у нового и есть последующие элементы
        while (cur.getKey() < key) {
            if (cur.getNext() == null) {
                cur.setNext(item);
                item.setPrevious(cur);
                return;
            }
            cur = cur.getNext();
        }
        item.setNext(cur);
        if (cur.getPrevious() != null) {
            cur = cur.getPrevious();
            cur.setNext(item);
            item.setPrevious(cur);
        }
    }

    public T delete() {
        ItemList<T> item = first;
        first = first.getNext();
        return item.getValue();
    }
}
