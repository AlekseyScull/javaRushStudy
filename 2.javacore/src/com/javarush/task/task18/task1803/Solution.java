package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> bytes = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(reader.readLine())) {
            while (fis.available() > 0) {
                bytes.add(fis.read());
            }
        }
        reader.close();
        System.out.println(bytes);
        int count = 0;
        int maxCount = 0;
        String result = "";
        for (int i = 0; i < bytes.size(); i++) {
            if (count > maxCount) {
                maxCount = count;
                result = bytes.get(i).toString();
            } else if (count == maxCount) {
                result += " " + bytes.get(i);
            }
            count = 0;
            for (int j = i; j < bytes.size(); j++) {
                if (bytes.get(i) == bytes.get(j)) {
                    count++;
                }
            }
        }
        System.out.println(result);
    }
}
