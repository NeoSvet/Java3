package ru.neosvet.algoritmy4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 4.1:");
        long time1 = System.nanoTime();
        MyStack<String> stack = new MyStack<>();
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        long time2 = System.nanoTime();
        System.out.println("MyStack time: " + (time2 - time1));


        System.out.println("Задание 4.2:");
        time1 = System.nanoTime();
        MyQueue<String> queue = new MyQueue<>();
        queue.push("item1");
        queue.push("item2");
        queue.push("item3");
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
        time2 = System.nanoTime();
        System.out.println("MyQueue time: " + (time2 - time1));

        System.out.println("Задание 4.3:");
        time1 = System.nanoTime();
        MyDeque<String> deque = new MyDeque<>();
        deque.addBack("item1");
        deque.addBack("item2");
        deque.addBack("item3");
        while (!deque.isEmpty()) {
            System.out.println(deque.popBack());
        }

        time2 = System.nanoTime();
        System.out.println("MyDeque time (back): " + (time2 - time1));
        time1 = System.nanoTime();

        deque.addFront("item1");
        deque.addFront("item2");
        deque.addFront("item3");
        while (!deque.isEmpty()) {
            System.out.println(deque.popFront());
        }
        time2 = System.nanoTime();
        System.out.println("MyDeque time (front): " + (time2 - time1));

        System.out.println("Задание 4.4:");
        time1 = System.nanoTime();
        MyPriorityQueue<String> queueP = new MyPriorityQueue<>();
        queueP.push("pr3", 3);
        queueP.push("pr4", 4);
        queueP.push("pr5", 5);
        queueP.push("pr1", 1);
        queueP.push("pr2", 2);
        while (!queueP.isEmpty()) {
            System.out.println(queueP.pop());
        }
        time2 = System.nanoTime();
        System.out.println("MyPriorityQueue time: " + (time2 - time1));

        System.out.println("Задание 4.5:");
        time1 = System.nanoTime();
        LinkedStack<String> stackL = new LinkedStack<>();
        stackL.push("item1");
        stackL.push("item2");
        stackL.push("item3");
        while (!stackL.isEmpty()) {
            System.out.println(stackL.pop());
        }
        time2 = System.nanoTime();
        System.out.println("LinkedStack time: " + (time2 - time1));

        time1 = System.nanoTime();
        LinkedQueue<String> queueL = new LinkedQueue<>();
        queueL.push("item1");
        queueL.push("item2");
        queueL.push("item3");
        while (!queueL.isEmpty()) {
            System.out.println(queueL.pop());
        }
        time2 = System.nanoTime();
        System.out.println("LinkedQueue time: " + (time2 - time1));
    }
}
