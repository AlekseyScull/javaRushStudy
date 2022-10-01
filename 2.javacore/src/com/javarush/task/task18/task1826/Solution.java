package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream(args[1]);
             FileOutputStream fos = new FileOutputStream(args[2])) {
            switch (args[0]) {
                case "-e":
                    encrypt(fis, fos);
                    break;
                case "-d":
                    decrypt(fis, fos);
                    break;
                default:
                    break;
            }
        }
    }

    private static void decrypt(FileInputStream in, FileOutputStream out) throws IOException {
        while (in.available() > 0) {
            out.write(in.read() + 1);
        }
    }

    private static void encrypt(FileInputStream in, FileOutputStream out) throws IOException {
        while (in.available() > 0) {
            out.write(in.read() - 1);
        }
    }

}
