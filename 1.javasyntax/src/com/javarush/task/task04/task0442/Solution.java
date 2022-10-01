package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int in;
        while (true) {
            in = Integer.parseInt(reader.readLine());
            result += in;
            if (in == -1) {
                System.out.println(result);
                break;
            }
        }

    }
}
