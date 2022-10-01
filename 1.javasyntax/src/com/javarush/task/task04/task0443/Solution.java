package com.javarush.task.task04.task0443;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как назвали, так назвали
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int day = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());
        System.out.println("Меня зовут " + name + "." + "\nЯ родился " +day + "." + month + "." + year);

    }
}
