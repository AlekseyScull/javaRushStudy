package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            Map<Integer, Integer> byteCount = new HashMap<>();
            try (FileReader fileReader = new FileReader(fileName)) {
                while (fileReader.ready()) {
                    int readedByte;
                    if (byteCount.containsKey((readedByte = fileReader.read()))) {
                        int count = byteCount.get(readedByte);
                        byteCount.replace(readedByte, ++count);
                    } else {
                        byteCount.put(readedByte, 1);
                    }
                }
            } catch (IOException e) {
            }
            int max = 0;
            int popularByte = 0;
            for (Integer key : byteCount.keySet()) {
                if (byteCount.get(key) > max) {
                    max = byteCount.get(key);
                    popularByte = key;
                }
            }
            resultMap.put(fileName, popularByte);
        }
    }
}
