package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int charCount = s.length();
        int num = Integer.parseInt(s);

        for (int i = charCount; i > 0; i--) {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            num /= 10;
        }
        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
