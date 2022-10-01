package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = 0;
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            if (len < strings.get(i).length()) {
                len = strings.get(i).length();
            }
        }
        for (String string : strings) {
            if (string.length() == len) {
                System.out.println(string);
            }
        }
    }
}
