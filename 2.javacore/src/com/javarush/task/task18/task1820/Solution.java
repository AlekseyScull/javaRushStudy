package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName1)) {
            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
        }
        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            String[] strings = sb.toString().split(" ");
            for (String string : strings) {
                fileWriter.write(Math.round(Double.parseDouble(string)) + " ");
            }
        }
    }
}
