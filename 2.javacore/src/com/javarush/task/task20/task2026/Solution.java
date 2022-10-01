package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            boolean check = false;
            boolean inRectangleHor = false;
            for (int j = 0; j < a.length; j++) {

                if (a[i][j] == 1 && !inRectangleHor) {
                    inRectangleHor = true;
                    if (i > 0) {
                        if (a[i - 1][j] == 0) {
                            count++;
                        } else if (a[i - 1][j] == 1 && check) {
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if (a[i][j] == 0) {
                    inRectangleHor = false;
                }
                check = i > 0 && a[i - 1][j] == 1;

            }
        }
        return count;
    }
}
