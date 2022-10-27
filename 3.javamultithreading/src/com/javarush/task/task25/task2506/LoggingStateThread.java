package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State state;
        State oldState = null;
        do {
            state = thread.getState();
            if (oldState != state) {
                System.out.println(state);
                oldState = state;
            }
        } while (state != State.TERMINATED);

    }

}
