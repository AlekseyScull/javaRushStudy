package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fis = new FileInputStream(reader.readLine())) {
            if (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                int count = 0;
                fis.read(buffer);
                for (byte b : buffer) {
                    if (b == 44) {
                        count++;
                    }
                }
                System.out.println(count);

            }
        }
        reader.close();
    }
}
