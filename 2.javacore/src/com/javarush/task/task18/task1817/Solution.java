package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        double rel = 0.00d;
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            int allChars = fileInputStream.available();
            int spaceCount = 0;
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == ' ') {
                    spaceCount++;
                }
            }
            rel = (double) spaceCount / allChars * 100;
        }
        System.out.printf("%.2f", rel);

    }
}
