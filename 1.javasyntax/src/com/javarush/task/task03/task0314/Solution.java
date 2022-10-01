package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 1;
        while (a <= 10) {
            int b = 1;
            while (b <= 10) {
                int result = a * b;
                System.out.print(result + " ");
                b++;
            }
            System.out.println();
            a++;
        }

    }
}
