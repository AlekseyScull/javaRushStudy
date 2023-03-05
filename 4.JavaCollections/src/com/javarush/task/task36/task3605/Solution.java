package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Set<Character> characterSet = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
        }
        for (char c : sb.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                characterSet.add(Character.toLowerCase(c));
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i == characterSet.size()) break;
            System.out.print(characterSet.toArray()[i]);
        }
    }
}
