package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(3);
        print((Integer) 5);

    }

    //Напишите тут ваши методы
    public static void print(int i) {
        System.out.println("int " + i);
    }
    public static void print(Integer i) {
        System.out.println("Integer " + i);
    }
}
