package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        StringBuilder builder = new StringBuilder();
        while (true) {
            String data = reader.readLine();
            builder.append(data).append("\n");
            if (data.equals("exit")) {
                break;
            }
        }
        writer.write(builder.toString());
        writer.close();
    }
}
