package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine().replaceAll("\\p{P}", "");
                fileWriter.write(line);
            }
        }
    }
}

