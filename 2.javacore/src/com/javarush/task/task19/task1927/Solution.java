package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(myOutputStream);
        System.setOut(myPrintStream);
        testString.printSomething();
        String[] strs = myOutputStream.toString().split("\r\n");
        System.setOut(console);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
