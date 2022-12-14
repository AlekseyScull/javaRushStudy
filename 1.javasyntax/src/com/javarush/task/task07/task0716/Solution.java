package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        ArrayList<String> result = new ArrayList<>();
        for (String string : strings) {
            if (string.contains("л") && !string.contains("р")) {
                result.add(string);
            }
            if (!string.contains("л") && string.contains("р")) {
                continue;
            }
            result.add(string);
        }
        return result;
    }
}