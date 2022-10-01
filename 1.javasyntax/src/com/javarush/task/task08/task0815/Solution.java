package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Sidorov", "Vasya");
        map.put("Ivanov", "Petr");
        map.put("Petrov", "Ivan");
        map.put("Sidorov", "Petr");
        map.put("Ivanov", "Vasya");
        map.put("Petrov", "Vasya");
        map.put("Sidorov", "Ivan");
        map.put("Vasechkin", "Vasya");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values()) {
            if (s.equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
