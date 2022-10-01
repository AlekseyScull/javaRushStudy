package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        int[] counts = new int[128];
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                counts[fileReader.read()]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println((char) i + " " + counts[i]);
            }
        }
    }
}
