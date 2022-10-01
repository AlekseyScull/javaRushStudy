package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bytes = new int[256];
        try (FileInputStream fis = new FileInputStream(reader.readLine())) {
            while (fis.available() > 0) {
                bytes[fis.read()] = 1;
            }
        }
        reader.close();
        ArrayList<Integer> uniqBytes = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 1) {
                uniqBytes.add(i);
            }
        }
        Collections.sort(uniqBytes);
        for (Integer uniqByte : uniqBytes) {
            System.out.print(uniqByte + " ");
        }
    }
}
