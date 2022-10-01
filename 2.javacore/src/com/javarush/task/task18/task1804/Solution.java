package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bytes = new int[256];
        try (FileInputStream fis = new FileInputStream(reader.readLine())) {
            while (fis.available() > 0) {
                bytes[fis.read()] += 1;
            }
        }
        reader.close();
        int minByte = Integer.MAX_VALUE;
        for (int i = 1; i < bytes.length; i++) {
            if (minByte > bytes[i] && bytes[i] != 0) {
                minByte = bytes[i];
            }
        }
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == minByte) {
                result += i + " ";
            }
        }
        System.out.println(result);
    }
}
