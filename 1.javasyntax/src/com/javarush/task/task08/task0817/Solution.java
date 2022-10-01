package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Sidorov", "Vasya");
        map.put("Ivanova", "Petr");
        map.put("Petrova", "Denis");
        map.put("Sidorova", "Petr");
        map.put("Ivanovy", "Vasya");
        map.put("Petrovy", "Vasya");
        map.put("Sidorovy", "Ivan");
        map.put("Vasechkin", "Vasya");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, String> copy = new HashMap<>(map);
        for (String value : copy.values()) {
            int count = 0;
            for (String s : copy.values()) {
                if (value.equals(s)) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, value);
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
