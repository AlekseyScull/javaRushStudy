package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        StringBuffer sb = new StringBuffer();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().replaceAll("\\p{P}", "").split(" ");
                for (String string : strings) {
                    for (char c : string.toCharArray()) {
                        if (Character.isDigit(c)) {
                            sb.append(string).append(" ");
                            break;
                        }
                    }
                }
            }
        }
        try (FileWriter fileWriter = new FileWriter(args[1])) {
            fileWriter.write(sb.toString().trim());
        }
    }
}
