package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] ints = {1, 3, 9, 27, 81, 243, 729, 2187};

        StringBuilder sb = new StringBuilder(number + " =");
        List<Integer> result = new ArrayList<>();
        for (int anInt : ints) {
            int leftOver = number % 3 == 2 ? -1 : number % 3;
            result.add(leftOver * anInt);
            number = number / 3;
            if (leftOver == -1) number += 1;
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < 0) {
                sb.append(" - ").append(ints[i]);
            } else if (result.get(i) > 0) {
                sb.append(" + ").append(ints[i]);
            }
        }
        System.out.println(sb);
    }
}