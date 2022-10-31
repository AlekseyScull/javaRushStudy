package com.javarush.task.task25.task2512;

import java.util.*;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Throwable throwable = e;
        List<Throwable> throwables = new ArrayList<>();
        while (throwable != null) {

            throwables.add(throwable);
            throwable = throwable.getCause();

        }
        Collections.reverse(throwables);
        for (Throwable throwable1 : throwables) {
            System.out.println(throwable1);
        }

    }

    public static void main(String[] args) throws Exception {
    }
}
