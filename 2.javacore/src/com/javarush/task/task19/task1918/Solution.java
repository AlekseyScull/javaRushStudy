package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        String fileName;
        int tagLen = args[0].length() + 1;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                sb.append(fileReader.readLine());
            }
        }
        String str = sb.toString().replaceAll("\n\r", "");
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i).contains(args[0])) {
                int index = str.substring(i).indexOf(args[0]) + i;
                i = index + tagLen;
                if (str.charAt(index - 1) == '/') {
                    indexes.add(index * -1);
                } else if (str.charAt(index - 1) == '<') {
                    indexes.add(index);
                }
            }
        }
        System.out.println(indexes);
        for (int i = 0; i < indexes.size() - 1; i++) {
            if (indexes.get(i) > 0) {
                if (indexes.get(i) > indexes.get(i + 1)) {
                    strings.add(str.substring(indexes.get(i) - 1, Math.abs(indexes.get(i + 1)) + tagLen));
                } else {
                    int count = 0;
                    for (int j = i; j < indexes.size() - 1; j++) {
                        if (indexes.get(j) > 0) {
                            count++;
                        } else {
                            count--;
                        }
                        if (indexes.get(j) < 0 && count == 0) {
                            strings.add(str.substring(indexes.get(i) - 1, Math.abs(indexes.get(j)) + tagLen));
                            break;
                        }
                    }
                }
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
