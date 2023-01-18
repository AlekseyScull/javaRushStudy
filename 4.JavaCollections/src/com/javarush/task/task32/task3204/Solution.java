package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int countUpperCase = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char c = (char) (97 + (int) (Math.random() * 25));
            if (Math.random() > 0.7) {
                c = Character.toUpperCase(c);
                countUpperCase++;
            }
            sb.append(c);
        }
        int randomInt = (int) (Math.random() * 8);
        if (Character.isUpperCase(sb.charAt(randomInt))) countUpperCase--;
        sb.replace(randomInt, randomInt + 1, String.valueOf((int) (Math.random() * 10)));
        if (countUpperCase == 0) {
            while (true) {
                int anotherRnd = (int) (Math.random() * 8);
                if (anotherRnd != randomInt) {
                    sb.replace(anotherRnd, anotherRnd + 1, String.valueOf(Character.toUpperCase(sb.charAt(anotherRnd))));
                    break;
                }
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(sb.toString().getBytes());
            out.flush();
        } catch (IOException e) {
        }
        return out;
    }
}
