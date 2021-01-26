package ru.neosvet.algoritmy7;

public class Vertex {
    private String label;
    public boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
