package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n > 150) {
            return "Число слишком большое";
        } else if (n < 0) {
            return "0";
        } else {
            BigDecimal result = new BigDecimal(1);
            for (int i = 0; i < n; i++) {
                result = result.multiply(new BigDecimal(i + 1));
            }
            return result.toString();
        }
    }
}
