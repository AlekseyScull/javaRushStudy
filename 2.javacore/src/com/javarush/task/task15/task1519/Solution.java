package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (!(s = reader.readLine()).equals("exit")) {
            boolean maybeDouble = s.contains(".");
            double parsedString;
            try {
                parsedString = Double.parseDouble(s);
            } catch (NumberFormatException ignored) {
                print(s);
                return;
            }
            if (maybeDouble) {
                print(parsedString);
            } else if (parsedString > 0 && parsedString < 128) {
                print((short) parsedString);
            } else {
                print((int) parsedString);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
