package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        solutions[0] = new Solution();
        solutions[1] = new Solution();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solutions[i].innerClasses[j] = solutions[i].new InnerClass();
            }
        }
        return solutions;
    }

    public static void main(String[] args) {

    }
}
