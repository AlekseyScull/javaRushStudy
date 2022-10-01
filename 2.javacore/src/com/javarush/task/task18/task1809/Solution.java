package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fis = new FileInputStream(reader.readLine());
             FileOutputStream fos = new FileOutputStream(reader.readLine())) {
            if (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                for (int i = buffer.length - 1; i >= 0; i--) {
                    fos.write(buffer[i]);
                }
            }
        }
    }
}
