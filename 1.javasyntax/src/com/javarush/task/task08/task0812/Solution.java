package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ints.add(Integer.parseInt(reader.readLine()));
        }
        int count = 1;
        int result = 0;
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i - 1) == ints.get(i)) {
                count++;
            } else if (count > result) {
                result = count;
                count = 1;
            }
        }
        if (count > result) {
            result = count;
        }
        System.out.println(result);
    }
}
