package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> div3 = new ArrayList<Integer>();
        ArrayList<Integer> div2 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (Integer integer : list) {
            if (integer % 3 == 0) {
                div3.add(integer);
                if (integer % 2 == 0) {
                    div2.add(integer);
                }
            } else if (integer % 2 == 0) {
                div2.add(integer);
            } else {
                other.add(integer);
            }
        }
        printList(div3);
        printList(div2);
        printList(other);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
