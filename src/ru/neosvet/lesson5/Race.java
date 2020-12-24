package ru.neosvet.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private int count_parties;
    private CyclicBarrier starter, finisher;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void waitParties(int count) {
        count_parties = count;
        starter = new CyclicBarrier(count, () -> {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        });
        finisher = new CyclicBarrier(count, () -> {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        });
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    }

    public void checkReady() throws BrokenBarrierException, InterruptedException {
        starter.await();
    }

    public void finish() {
        try {
            finisher.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goWith(Car car) {
        for (int i = 0; i < stages.size(); i++) {
            stages.get(i).go(car);
        }
    }
}
