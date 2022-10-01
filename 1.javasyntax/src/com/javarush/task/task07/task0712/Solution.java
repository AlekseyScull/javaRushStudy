package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());

            if (strings.get(i).length() > max) {
                max = strings.get(i).length();
            }
            if (strings.get(i).length() < min) {
                min = strings.get(i).length();
            }
        }
        for (String string : strings) {
            if (string.length() == max || string.length() == min) {
                System.out.println(string);
                break;
            }
        }
    }
}
