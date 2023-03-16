package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: "); //LXXXVIII, MCMXCIX
        String romanString = bufferedReader.readLine();
        bufferedReader.close();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
        System.out.println("Conversion result equals " + romanToInteger2(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> romeMap = new HashMap<>();
        romeMap.put('M', 1000);
        romeMap.put('D', 500);
        romeMap.put('C', 100);
        romeMap.put('L', 50);
        romeMap.put('X', 10);
        romeMap.put('V', 5);
        romeMap.put('I', 1);

        int result = 0;
        int reducer = 0;
        int count = 1;
        int lastValue = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            Integer romeValue = romeMap.get(c);
            if (result > 0 && romeValue > result) {
                result = -1;
                reducer = 0;
                break;
            }
            if (romeValue == lastValue) {
                count++;
                if (count == 4) {
                    result = -1;
                    reducer = 0;
                    break;
                }
            } else {
                lastValue = romeValue;
                count = 1;
            }
            if ((c == 'I' || c == 'X' || c == 'C') && (reducer == 0)) {
                reducer = romeValue;
            } else if (reducer >= romeValue) {
                result += reducer;
                reducer = 0;
                if (c == 'I' || c == 'X' || c == 'C') {
                    reducer = romeValue;
                } else {
                    result += romeValue;
                }
            } else {
                if (reducer > 0 && (romeValue / reducer) > 10) {
                    result = -1;
                    reducer = 0;
                    break;
                } else {
                    result += romeValue - reducer;
                    reducer = 0;
                }
            }
        }
        result += reducer;
        return result;
    }

    public static int romanToInteger2(String s) {
        Map<Character, Integer> romeMap = new HashMap<>();
        romeMap.put('M', 1000);
        romeMap.put('D', 500);
        romeMap.put('C', 100);
        romeMap.put('L', 50);
        romeMap.put('X', 10);
        romeMap.put('V', 5);
        romeMap.put('I', 1);

        int result = 0;
        int lastValue = 0;
        int romeValue;

        for (int i = s.length() - 1; i >= 0; i--) {
             romeValue = romeMap.get(s.charAt(i));
             if (romeValue < lastValue) {
                 result -= romeValue;
             } else {
                 result += romeValue;
             }
             lastValue = romeValue;
        }
        return result;
    }
}
