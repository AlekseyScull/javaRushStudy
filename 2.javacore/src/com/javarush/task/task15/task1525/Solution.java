package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }

    static {
        try {
            FileInputStream reader = new FileInputStream(Statics.FILE_NAME);
            StringBuilder sb = new StringBuilder();
            while (reader.available() > 0) {
                char c = (char) reader.read();
                if (c != '\r') {
                    sb.append(c);
                } else {
                    lines.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
            lines.add(sb.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
