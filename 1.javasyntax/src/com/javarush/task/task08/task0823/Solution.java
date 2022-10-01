package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        String[] strings = string.split(" ");
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += Character.toUpperCase(strings[i].charAt(0)) + strings[i].substring(1) + " ";
        }

        System.out.println(result);
    }
}
