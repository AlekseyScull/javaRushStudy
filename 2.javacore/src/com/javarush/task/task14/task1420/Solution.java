package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int result = 0;

        if (num1 % num2 != 0 || num2 % num1 != 0) {
            int min = num1 < num2 ? num1 : num2;
            for (int i = min; i > 0; i--) {
                if (num1 % i == 0 && num2 % i == 0) {
                    result = i;
                    break;
                }
            }
        } else {
            result = num1 < num2 ? num1 : num2;
        }
        System.out.println(result);
    }
}
