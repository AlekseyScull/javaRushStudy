package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<String> lines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }

        switch (args[0]) {
            case "-u":
                for (int i = 0; i < lines.size(); i++) {
                    int id = Integer.parseInt(lines.get(i).substring(0, 8).trim());
                    if (id == Integer.parseInt(args[1])) {
                        lines.remove(i);
                        lines.add(i, stringFiller(args[1], 8) + stringFiller(args[2], 30) + stringFiller(args[3], 8) + stringFiller(args[4], 4));
                        return;
                    }
                }
                break;
            case "-d":
                for (int i = 0; i < lines.size(); i++) {
                    int id = Integer.parseInt(lines.get(i).substring(0, 8).trim());
                    if (id == Integer.parseInt(args[1])) {
                        lines.remove(i);
                        return;
                    }
                }
                break;
            default:
                break;
        }

        try (FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : lines) {
                bufferedWriter.append(line);
                bufferedWriter.newLine();
            }
        }
    }

    public static String stringFiller(String str, int target) {
        StringBuilder sb = new StringBuilder(str);
        if (str.length() < target) {
            while (sb.length() < target) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return sb.substring(0, target);
        }
    }
}
