package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[10];
        int[] arLegth = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
            arLegth[i] = array[i].length();
        }
        for (int i : arLegth) {
            System.out.println(i);
        }
    }
}
