package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'\u0430', '\u044F', '\u0443', '\u044E', '\u0438', '\u044B', '\u044D', '\u0435', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] chars = s.toCharArray();
        String first = "";
        String second = "";
        for (char aChar : chars) {
            if (isVowel(aChar)) {
                first += aChar + " ";
            } else if (aChar != ' ') {
                second += aChar + " ";
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}