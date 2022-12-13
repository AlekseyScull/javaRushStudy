package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String sub = s.substring(0, 2);
        if (sub.startsWith("0")) {
            if (sub.endsWith("x")) return Integer.toString(Integer.parseInt(s.substring(2), 16));
            if (sub.endsWith("b")) return Integer.toString(Integer.parseInt(s.substring(2), 2));
            return Integer.toString(Integer.parseInt(s.substring(1), 8));
        }
        return Integer.toString(Integer.parseInt(s));
    }
}
