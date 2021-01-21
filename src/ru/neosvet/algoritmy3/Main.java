package ru.neosvet.algoritmy3;

import ru.neosvet.algoritmy1.Cat;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //заполнение массива:
        Integer[] mArray = new Integer[5000];
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }

        System.out.println("Задание 3.1:");
        long time1 = System.nanoTime();
        List<Integer> list = new ArrayList<>(Arrays.asList(mArray));
        long time2 = System.nanoTime();
        System.out.println("time for convert array to list: " + (time2 - time1));

        System.out.println("Задание 3.2:");
        time1 = System.nanoTime();
        list.add(33);
        time2 = System.nanoTime();
        System.out.println("time for add to list: " + (time2 - time1));

        time1 = System.nanoTime();
        list.remove(3);
        time2 = System.nanoTime();
        System.out.println("time for remove from list: " + (time2 - time1));

        time1 = System.nanoTime();
        int n = random.nextInt(4999);
        System.out.print(list.get(n));
        System.out.print("; ");
        time2 = System.nanoTime();
        System.out.println("time for get from index " + n + " : " + (time2 - time1));

        time1 = System.nanoTime();
        n = random.nextInt(4999);
        System.out.print(list.get(n));
        System.out.print("; ");
        time2 = System.nanoTime();
        System.out.println("time for get from index " + n + ": " + (time2 - time1));

        time1 = System.nanoTime();
        n = random.nextInt(4999);
        System.out.print(list.get(n));
        System.out.print("; ");
        time2 = System.nanoTime();
        System.out.println("time for get from index " + n + ": " + (time2 - time1));

        //Задание 3.3:
        OneLinkList<String> linkListExample = new OneLinkList<>();

        System.out.println("Задание 3.4:");
        TwoLinkList<Cat> myLinkList = new TwoLinkList<>();
        myLinkList.add(new Cat("Борис", 7));
        myLinkList.add(new Cat("Мурка", 3));
        myLinkList.add(new Cat("Джек", 1));
        LinkedList<Cat> linkList = new LinkedList<>();

        ItemTwoList<Cat> item = myLinkList.getFirst();
        linkList.add(item.getValue());
        System.out.println("Current0: " + item.toString());
        if (item.hasPrevious())
            System.out.println("Previous0: " + item.getPrevious().toString());
        System.out.println("Next0: " + item.getNext().toString());
        item = item.getNext();
        linkList.add(item.getValue());
        System.out.println("Current1: " + item.toString());
        System.out.println("Previous1: " + item.getPrevious().toString());
        System.out.println("Next1: " + item.getNext().toString());
        item = item.getNext();
        linkList.add(item.getValue());
        System.out.println("Current2: " + item.toString());
        System.out.println("Previous2: " + item.getPrevious().toString());
        if (item.hasNext())
            System.out.println("Next2: " + item.getNext().toString());

        System.out.println("Задание 3.5:");
        System.out.println("size list: " + linkList.size());
        Iterator<Cat> iterator = linkList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            iterator.remove();
        }
        System.out.println("size list: " + linkList.size());
    }
}
