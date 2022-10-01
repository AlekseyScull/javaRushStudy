package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String str = outputStream.toString().replace("\r\n", "");
        String[] spited = str.split(" ");
        int arg1 = Integer.parseInt(spited[0]);
        int arg2 = Integer.parseInt(spited[2]);
        switch (spited[1]) {
            case "+":
                System.out.print(str + (arg1 + arg2));
                break;
            case "-":
                System.out.print(str + (arg1 - arg2));
                break;
            case "*":
                System.out.print(str + (arg1 * arg2));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

