package ru.neosvet.algoritmy6;

public class Node<T extends HasID> {
    private final T data;
    public Node<T> left, right;

    public Node(T data) {
        this.data = data;
    }

    public int getId() {
        return data.getId();
    }

    public void display() {
        System.out.println(data.toString());
    }
}
