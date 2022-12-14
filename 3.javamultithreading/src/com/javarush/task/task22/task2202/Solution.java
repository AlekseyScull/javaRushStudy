package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splited = string.split(" ");
        if (splited.length < 5) {
            throw new TooShortStringException();
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            sb.append(splited[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {

    }

}
