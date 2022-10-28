package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread thread;


    @Override
    public void run() {
        while (thread.isAlive()){

            try {
                System.out.println(this.thread.getName());
                Thread.sleep(100);

            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this::run, threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}
