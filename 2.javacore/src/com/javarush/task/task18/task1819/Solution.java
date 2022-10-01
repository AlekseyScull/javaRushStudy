package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        ArrayList<Byte> bytes = new ArrayList<>();

        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            while (fis2.available() > 0) {
                bytes.add((byte) fis2.read());
            }
            while (fis1.available() > 0) {
                bytes.add((byte) fis1.read());
            }
        }
        try (FileOutputStream fos = new FileOutputStream(file1)) {
            for (byte aByte : bytes) {
                fos.write(aByte);
            }
        }
    }
}
