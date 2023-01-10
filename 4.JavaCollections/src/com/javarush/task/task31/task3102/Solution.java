package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> allFiles = new ArrayList<>();
        Queue<File> dirs = new LinkedList<>();
        dirs.add(new File(root));
        while (!dirs.isEmpty()) {
            for (File f : dirs.poll().listFiles()) {
                if (f.isDirectory()) {
                    dirs.add(f);
                } else if (f.isFile()) {
                    allFiles.add(f.getPath());
                }
            }
        }
        return allFiles;
    }

    public static void main(String[] args) {

    }
}
