package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName1)) {
            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
        }
        String[] strings = sb.toString().split(" ");
        int value = 0;
        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            for (String string : strings) {
                if (!string.contains(".")) {
                    try {
                        value = Integer.parseInt(string);
                        fileWriter.write(value + " ");
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
    }
}
