package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {

                map.put(String.valueOf(i), String.format("Some text for %d", i));
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}
