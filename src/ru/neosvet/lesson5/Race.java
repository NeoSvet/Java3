package ru.neosvet.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private int parties;
    private CyclicBarrier starter, finisher;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void waitParties(int parties) {
        this.parties = parties;
        starter = new CyclicBarrier(parties, () -> {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        });
        finisher = new CyclicBarrier(parties, () -> {
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
}
