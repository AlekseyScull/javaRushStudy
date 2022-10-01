package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        int start = url.indexOf('?');
        String keys = url.substring(start + 1);
        String[] strings = keys.split("&");
        String result = "";
        String tmp = "";
        for (String string : strings) {
            if (string.contains("=")) {
                if (string.contains("obj")) {
                    tmp = string.substring(string.indexOf('=') + 1);

                } else {
                    result += string.substring(0, string.indexOf('=')) + " ";
                }

            } else {
                result += string + " ";
            }
        }

        System.out.println(result);
        if (!tmp.equals("")) {
            try {
                alert(Double.parseDouble(tmp));
            } catch (Exception e) {
                alert(tmp);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
