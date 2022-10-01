package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }
        try (BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2))) {
            while (fileReader1.ready() || fileReader2.ready()) {
                strings1.add(fileReader1.readLine());
                strings2.add(fileReader2.readLine());
            }
        }
        int counterForStr1 = 0;
        boolean isNotSame = false;
        for (int i = 0; i < strings1.size(); i++) {
            if (strings1.get(counterForStr1) != null && strings1.get(counterForStr1).equals(strings2.get(i))) {
                lines.add(new LineItem(Type.SAME, strings1.get(counterForStr1)));
                counterForStr1++;
            } else {
                if (counterForStr1 + 1 < strings1.size()) {
                    if (strings1.get(counterForStr1).equals(strings2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, strings2.get(i)));
                        lines.add(new LineItem(Type.SAME, strings1.get(counterForStr1)));
                        counterForStr1++;
                    } else if (strings1.get(counterForStr1 + 1).equals(strings2.get(i))) {
                        lines.add(new LineItem(Type.REMOVED, strings1.get(counterForStr1)));
                        lines.add(new LineItem(Type.SAME, strings2.get(i)));
                        counterForStr1++;
                        counterForStr1++;
                    }
                } else {
                    if (strings1.get(counterForStr1) != null && !isNotSame) {
                        lines.add(new LineItem(Type.REMOVED, strings1.get(counterForStr1)));
                        isNotSame = true;
                    } else if (strings2.get(i) != null && !isNotSame) {
                        lines.add(new LineItem(Type.ADDED, strings2.get(i)));
                        isNotSame = true;
                    }
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
