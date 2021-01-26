package ru.neosvet.algoritmy7;

public class Main {
    public static void main(String[] args) {
        /* Задание 7.1
           Самый очевидный пример графа - это
           города / пунты назначений (вершины графа)
           и дороги / пути между ними (ребра).
         */

        System.out.println("Задание 7.2");

        Graph graph = new Graph();
        graph.addVertex("Москва"); //0
        graph.addVertex("Санкт-Петербург"); //1
        graph.addVertex("Великий Новгород"); //2
        graph.addVertex("Воронеж"); //3
        graph.addVertex("Тула"); //4
        graph.addVertex("Ладога"); //5
        graph.addVertex("Петрозоводск"); //6

        graph.addLink(0, 2);
        graph.addLink(0, 4);
        graph.addLink(1, 2);
        graph.addLink(1, 5);
        graph.addLink(3, 4);
        graph.addLink(5, 6);

        graph.displayVertex(1);


        System.out.println();
        System.out.println("Задание 7.3");
        graph.displayDepthForVertex(1);


        System.out.println();
        System.out.println("Задание 7.4");
        graph.displayWideForVertex(1);
    }
}
