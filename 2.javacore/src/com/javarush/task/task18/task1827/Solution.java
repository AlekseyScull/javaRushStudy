package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (!args[0].equals("-c")) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bf = new BufferedReader(fileReader)) {
            ArrayList<Integer> list = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) != null) {
                int id = Integer.parseInt(line.substring(0, 8).trim());
                list.add(id);
            }

            int lastId = Collections.max(list);

            String productName = args[1];
            String price = (Double.parseDouble(args[2])) + "";
            String quantity = args[3];

            String productToAdd = stringFiller(lastId + "", 8) + stringFiller(productName, 30) + stringFiller(price, 8) + stringFiller(quantity, 4);
            System.out.println(productToAdd);

            try (FileWriter fileWriter = new FileWriter(fileName, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.newLine();
                bufferedWriter.append(productToAdd);
            }
        }
    }

    public static String stringFiller(String str, int target) {
        StringBuilder sb = new StringBuilder(str);
        if (str.length() < target) {
            while (sb.length() < target) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return sb.substring(0, target);
        }
    }
}