package com.javarush.task.task19.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/* 
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fos;

    public AdapterFileOutputStream(FileOutputStream fos) {
        this.fos = fos;
    }

    public static void main(String[] args) {

    }


    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fos.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }
}

