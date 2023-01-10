package com.javarush.task.task31.task3101;

import java.io.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newName = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(newName)) FileUtils.deleteFile(newName);
        FileUtils.renameFile(resultFileAbsolutePath, newName);
        getAndWriteFiles(path.listFiles(), newName);

    }

    public static void getAndWriteFiles(File[] files, File out) {
        try (FileWriter fw = new FileWriter(out, true)) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getAndWriteFiles(file.listFiles(), out);
                } else {
                    if (file.length() <= 50) {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        while (br.ready()) fw.write(br.read());
                        br.close();
                        fw.write("\n");
                    }
                }
            }
        } catch (IOException e) {

        }
    }
}


