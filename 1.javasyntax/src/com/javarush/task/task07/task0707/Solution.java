package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add("asd");
        list.add("asd1");
        list.add("asd12");
        list.add("asd123");
        list.add("asd1234");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
