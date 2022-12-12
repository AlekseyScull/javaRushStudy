package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private final List<Tablet> tabletList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tabletList = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {
        Tablet tablet = tabletList.get((int) Math.round(Math.random() * (tabletList.size() - 1)));
        try {
            Thread.sleep(interval);
        } catch (InterruptedException ignored) {
        }
        tablet.createTestOrder();
    }
}
