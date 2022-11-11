package com.javarush.task.task26.task2601;

import java.util.*;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        double median;
        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        } else {
            median = list.get(list.size() / 2);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) (Math.abs(o1 - median) - Math.abs(o2 - median));
            }
        });
        return list.toArray(new Integer[0]);
    }
}
