package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;

/* 
Числа по возрастанию
*/

public class Solution {
    public static int[] nums = new int[5];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        numsToMax();
        printNums();
    }

    public static void numsToMax() {
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static void printNums() {
        for (int i = 0; i < 5; i++) {
            System.out.println(nums[i]);
        }
    }
}
