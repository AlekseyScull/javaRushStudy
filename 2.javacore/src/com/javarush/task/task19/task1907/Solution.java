package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
        }
        String[] words = sb.toString().replace("\r", " ").replace("\n", " ").replace(".", "").replace(",", "").split(" ");
        int counter = 0;
        for (String word : words) {
            System.out.print(word + " ");
            if (word.equalsIgnoreCase("world")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
