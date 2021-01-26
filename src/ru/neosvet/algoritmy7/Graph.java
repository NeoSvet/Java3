package ru.neosvet.algoritmy7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int MAX = 10;
    private Vertex[] list;
    private boolean[][] links;
    private int size;

    public Graph() {
        list = new Vertex[MAX];
        links = new boolean[MAX][MAX];
        size = 0;

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                links[i][j] = false;

            }
        }
    }

    //Задание 7.2
    public void addVertex(String label) {
        list[size++] = new Vertex(label);
    }

    //Задание 7.2
    public void addLink(int index1, int index2) {
        links[index1][index2] = true;
        links[index2][index1] = true;
    }

    //Задание 7.2
    public void displayVertex(int index) {
        System.out.println(list[index].toString());
    }

    private int getUnvisitedLinkForVertex(int index) {
        for (int i = 0; i < size; i++) {
            if (links[index][i] && !list[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    //Задание 7.3
    public void displayDepthForVertex(int index) {
        list[index].wasVisited = true;
        displayVertex(index);
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        int v;
        boolean line = false;
        System.out.println("Lines:");
        while (!stack.isEmpty()) {
            v = getUnvisitedLinkForVertex(stack.peek());
            if (v == -1) {
                stack.pop();
                if (line) {
                    System.out.println("End line");
                    line = false;
                }
            } else {
                if (!line) {
                    System.out.println("Start line");
                    line = true;
                }
                list[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        clearVisits();
    }

    //Задание 7.4
    public void displayWideForVertex(int index) {
        list[index].wasVisited = true;
        displayVertex(index);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        int v, i;
        Level level = new Level();
        level.addTenant(index);
        System.out.println("Levels:");

        while (!queue.isEmpty()) {
            i = queue.peek();
            if (level.contains(i)) {
                level.closeIfNeed();
                level.upLevel();
            }

            v = getUnvisitedLinkForVertex(i);
            if (v == -1) {
                queue.poll();
            } else {
                level.openIfNeed();
                level.addTenant(v);
                list[v].wasVisited = true;
                displayVertex(v);
                queue.add(v);
            }
        }

        clearVisits();
    }

    private void clearVisits() {
        for (int i = 0; i < size; i++) {
            list[i].wasVisited = false;
        }
    }
}
