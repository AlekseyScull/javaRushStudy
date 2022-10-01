package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums1 = new int[20];
        int[] nums2 = new int[10];
        int[] nums3 = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < nums1.length; i++) {
            if (i < 10) {
                nums2[i] = nums1[i];
            } else {
                nums3[i - 10] = nums1[i];
            }
        }
        for (int i : nums3) {
            System.out.println(i);
        }
    }
}
