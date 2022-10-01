package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> salary = new TreeMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().split(" ");
                if (!salary.containsKey(strings[0])) {
                    salary.put(strings[0], Double.parseDouble(strings[1]));
                } else {
                    Double sum = salary.get(strings[0]) + Double.parseDouble(strings[1]);
                    salary.put(strings[0], sum);
                }
            }
        }
        for (Map.Entry<String, Double> entry : salary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
