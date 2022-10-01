package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] ints = getInts();
        maximum = ints[0];
        minimum = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (maximum < ints[i]) {
                maximum = ints[i];
            }
            if (minimum > ints[i]) {
                minimum = ints[i];
            }
        }

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
    public static int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        return nums;
    }
}
