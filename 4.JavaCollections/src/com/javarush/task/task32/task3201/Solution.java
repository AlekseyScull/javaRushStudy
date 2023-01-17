package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        Long pos = Long.parseLong(args[1]);
        pos = pos > file.length() ? file.length() : pos;
        file.seek(pos);
        file.write(args[2].getBytes());

    }
}
