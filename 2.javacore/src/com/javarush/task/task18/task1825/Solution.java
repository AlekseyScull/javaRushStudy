package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String partName;
        Set<String> parts = new TreeSet<>();
        while (!(partName = reader.readLine()).equals("end")) {
            parts.add(partName);
        }
        String fileName = parts.iterator().next();
        if (fileName.endsWith(".part1")) {
            fileName = fileName.replace(".part1", "");
        } else {
            throw new FileNotFoundException("part1 needed");
        }

        for (String part : parts) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(part));
                 FileWriter fileWriter = new FileWriter(fileName, true)) {
                while (fileReader.ready()) {
                    fileWriter.append(fileReader.readLine());
                }
            }
        }
    }
}
