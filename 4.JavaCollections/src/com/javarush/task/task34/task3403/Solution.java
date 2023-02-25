package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        boolean found = false;
        if (n <= 1) return;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                found = true;
                break;
            }
        }
        if (!found) System.out.print(n);
    }
}
