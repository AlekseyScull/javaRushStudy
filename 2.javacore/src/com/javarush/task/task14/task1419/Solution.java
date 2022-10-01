package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            Thread.sleep(-100);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] ints = {};
            ints[1] = 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fis = new FileInputStream("test.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("a");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object o = null;
            int s = (int) o;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List<String> ints = new ArrayList();
            ints.add((String)new Object());
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream s = new FileInputStream("\n");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List list = new ArrayList<>();
            list.remove(1);
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
