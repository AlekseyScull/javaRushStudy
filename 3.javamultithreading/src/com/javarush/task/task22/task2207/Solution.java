package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))) {
            while (fr.ready()) {
                strings.addAll(Arrays.asList(fr.readLine().split(" ")));
            }
        } catch (IOException e) {
        }

        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.size(); ) {
                if (i >= strings.size()) {
                    break;
                }
                if (strings.get(j).equals(new StringBuilder(strings.get(i)).reverse().toString()) && i != j) {
                    Pair pair = new Pair();
                    pair.first = strings.get(j);
                    pair.second = strings.get(i);
                    result.add(pair);
                    strings.remove(j);
                    strings.remove(i);
                    j = 0;
                } else {
                    j++;
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
