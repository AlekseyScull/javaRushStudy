package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) throws IOException {
        String fileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                ArrayList<String> strings = new ArrayList<>();
                String[] strs = fileReader.readLine().split(" ");
                for (String str : strs) {
                    int x;
                    try {
                        x = Integer.parseInt(str.replaceAll("\\p{P}", ""));
                        if (map.containsKey(x)) {
                            strings.add(str.replace(String.valueOf(x), map.get(x)));
                        } else {
                            strings.add(str);
                        }
                    } catch (NumberFormatException ignored) {
                        strings.add(str);
                    }
                }
                for (String s : strings) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
/*
Решение JavaRush
 */
        String fileLine;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((fileLine = in.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(fileLine);
            }
        }
    }
}
