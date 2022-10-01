package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(fis);

        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value % 2 == 0) {
                list.add(value);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        fis.close();
    }
}
