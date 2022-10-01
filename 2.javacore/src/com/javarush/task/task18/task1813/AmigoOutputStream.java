package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream original;
    public static String fileName = "C:/Users/ANNA/Desktop/test.txt";

    public AmigoOutputStream(FileOutputStream name) throws FileNotFoundException {
        super(fileName);
        this.original = name;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }

    @Override
    public void close() throws IOException {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }
}
