package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    static class Thread1 extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    static class Thread3 extends Thread {
        public void run() {
            try {
                while (!interrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    static class Thread4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) ;
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    static class Thread5 extends Thread {

        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summ = 0;
            String s;
            try {
                while (!(s = reader.readLine()).equals("N")) {
                    summ += Integer.parseInt(s);
                }
            } catch (IOException e) {
            }
            System.out.println(summ);
        }
    }
}