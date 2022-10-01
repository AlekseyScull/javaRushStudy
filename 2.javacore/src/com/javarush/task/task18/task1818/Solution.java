package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        try (FileWriter fileWriter = new FileWriter(file1, true);
             FileReader fileReader1 = new FileReader(file2);
             BufferedReader bufferedReader = new BufferedReader(fileReader1);
             FileReader fileReader2 = new FileReader(file3);
             BufferedReader bufferedReader1 = new BufferedReader(fileReader2)) {
            while (bufferedReader.ready()) {
                fileWriter.append(bufferedReader.readLine());
            }
            while (bufferedReader1.ready()) {
                fileWriter.append(bufferedReader1.readLine());
            }



        }
    }
}
