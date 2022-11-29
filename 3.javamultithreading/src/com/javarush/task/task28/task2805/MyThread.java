package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger atomicInteger = new AtomicInteger();

    public static int getMyPriority() {
        return atomicInteger.incrementAndGet() % 10 == 0 ? 10 : atomicInteger.get() % 10;
    }
    public MyThread() {
        this.setPriority(getMyPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(getMyPriority());
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(getMyPriority());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(getMyPriority());
    }
}
