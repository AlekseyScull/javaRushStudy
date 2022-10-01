package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
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
        Double max = 0d;
        ArrayList<String> result = new ArrayList<>();
        for (String s : salary.keySet()) {
            if (salary.get(s) > max) {
                max = salary.get(s);
            }
        }
        for (String s : salary.keySet()) {
            if (salary.get(s) == max) {
                result.add(s);
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
