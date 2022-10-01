package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (FileInputStream fis = new FileInputStream(reader.readLine());
             FileOutputStream fos2 = new FileOutputStream(reader.readLine());
             FileOutputStream fos3 = new FileOutputStream(reader.readLine())) {

            if (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                int firstHalf = (count + 1) / 2;

                fos2.write(buffer, 0, firstHalf);
                fos3.write(buffer, firstHalf, count / 2);
            }
        }
    }
}
