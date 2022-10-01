package com.javarush.task.task18.task1816;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int result = 0;
        Character[] tmp = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList(tmp));
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                char aChar = (char) fileInputStream.read();
                if (alphabet.contains(Character.toLowerCase(aChar))) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
