package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        file.seek(Long.parseLong(args[1]));
        byte[] text = new byte[args[2].length()];
        file.read(text, 0, text.length);
        file.seek(file.length());
        boolean equality = Arrays.equals(text, args[2].getBytes());
        file.write(String.valueOf(equality).getBytes());
    }
}
