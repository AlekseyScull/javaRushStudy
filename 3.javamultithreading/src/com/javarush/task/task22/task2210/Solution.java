package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokens = new StringTokenizer(query, delimiter);
        String[] strings = new String[tokens.countTokens()];
        int i = 0;
        while (tokens.hasMoreTokens()) {
            strings[i++] = tokens.nextToken();
        }
        return strings;
    }
}
