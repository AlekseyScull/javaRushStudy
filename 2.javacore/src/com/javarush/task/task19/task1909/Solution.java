package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
                String line = fileReader.readLine().replace(".", "!");
                fileWriter.write(line);
                if (fileReader.ready()) {
                    fileWriter.newLine();
                }
            }
        }
    }
}
