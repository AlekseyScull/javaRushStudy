package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] street = new int[15];
        int chet = 0;
        int neChet = 0;
        for (int i = 0; i < street.length; i++) {
            street[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                chet += street[i];
            } else {
                neChet += street[i];
            }
        }
        System.out.println(chet > neChet ? "В домах с четными номерами проживает больше жителей." : "В домах с нечетными номерами проживает больше жителей.");
    }
}
