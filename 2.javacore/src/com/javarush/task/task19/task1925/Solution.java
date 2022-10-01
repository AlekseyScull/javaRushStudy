package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {

                String[] strings = reader.readLine().split(" ");
                for (String string : strings) {
                    if (string.length() > 6) {
                        sb.append(string).append(",");
                    }
                }
            }
        }
        try (FileWriter fileWriter = new FileWriter(args[1])) {
            if (sb.length() > 6) {
                sb.replace(sb.length() - 1, sb.length(), "");
                fileWriter.write(sb.toString());
            }
        }
    }
}
