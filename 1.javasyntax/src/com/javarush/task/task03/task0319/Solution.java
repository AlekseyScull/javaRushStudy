package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Имя: ");
        String name = reader.readLine();
        System.out.print("ЗП: ");
        int num1 = Integer.parseInt(reader.readLine());
        System.out.print("Года: ");
        int num2 = Integer.parseInt(reader.readLine());
        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");

    }
}
