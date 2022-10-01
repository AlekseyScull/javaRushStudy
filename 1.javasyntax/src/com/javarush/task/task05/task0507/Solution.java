package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        int summ = 0;
        int count = 0;
        while (true) {
            num = Integer.parseInt(reader.readLine());
            if (num == -1) {
                double result =(double) summ / count;
                System.out.println(result);
                break;
            } else {
                count++;
                summ += num;
            }
        }
    }
}

