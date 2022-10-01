package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        //...
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))) {
            while (fr.ready()) {
                String[] strings = fr.readLine().split(" ");
                StringBuilder result = getLine(strings);
                System.out.println(result.toString());
            }
        } catch (IOException e) {
        }
    }

    public static StringBuilder getLine(String... words) {
        List<String> strings = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        int firstWord = 0;
        int count = 0;
        while (strings.size() > 0) {
            if (sb.length() == 0) {
                sb.append(strings.get(firstWord));
                strings.remove(firstWord);
            } else {
                char last = sb.charAt(sb.length() - 1);
                for (int i = 0; i < strings.size(); i++) {
                    int wordRandomNumber = (int)(strings.size() * Math.random());
                    char first = strings.get(wordRandomNumber).toLowerCase().charAt(0);
                    count++;
                    if (last == first) {
                        sb.append(" ");
                        sb.append(strings.get(wordRandomNumber));
                        strings.remove(strings.get(wordRandomNumber));
                        i = strings.size();
                        count = 0;
                    } else if (strings.size() == 1 || count > words.length) {
                        strings = new ArrayList<>(Arrays.asList(words));
                        sb = new StringBuilder();
                        firstWord = (int)(strings.size() * Math.random());
                        i = strings.size();
                        count = 0;
                        firstWord++;
                    }
                }
            }
        }

        return sb;
    }
}
