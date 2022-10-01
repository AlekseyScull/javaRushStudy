package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Petrov", 500);
        map.put("Ivanov", 1000);
        map.put("Sidorov", 750);
        map.put("Ivanova", 300);
        map.put("Petrova", 500);
        map.put("Sidorova", 250);
        map.put("Ivanovy", 650);
        map.put("Petrovy", 100);
        map.put("Sidorovy", 2000);
        map.put("Vasechkin", 3000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> entry : copy.entrySet()) {
            if (entry.getValue() < 500) {
                map.remove(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}