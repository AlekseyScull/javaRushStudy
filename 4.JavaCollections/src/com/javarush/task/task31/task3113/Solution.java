package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    static int filesCount = 0;
    static int dirCount = 0;
    static int sizeTotal = 0;

    public static void main(String[] args) throws IOException {
        Path folder = Paths.get(consoleReader());

        if (Files.isRegularFile(folder)) {
            System.out.println(folder.toAbsolutePath() + " - не папка");
        } else {
            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) filesCount++;
                    sizeTotal += Files.size(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(folder)) dirCount++;
                    return super.preVisitDirectory(dir, attrs);
                }
            });
        }
        System.out.println("Всего папок - " + dirCount);
        System.out.println("Всего файлов - " + filesCount);
        System.out.println("Общий размер - " + sizeTotal);
    }

    private static String consoleReader() {
        String in = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            in = br.readLine();
        } catch (IOException e) {
        }
        return in;
    }
}
