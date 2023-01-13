package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileToAdd = new File(args[0]);
        Map<String, ByteArrayOutputStream> buffer = new TreeMap<>();
        try (ZipInputStream in = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry = in.getNextEntry();
            while (entry != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] bffr = new byte[4 * 1024];
                int len;
                while ((len = in.read(bffr)) > 0) {
                    baos.write(bffr, 0, len);
                }
                buffer.put(entry.getName(), baos);
                in.closeEntry();
                entry = in.getNextEntry();
            }
        }
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(args[1]))) {
            try (FileInputStream fis = new FileInputStream(fileToAdd)) {
                boolean contain = false;
                if (buffer.containsKey(fileToAdd.getName())) {
                    buffer.remove(fileToAdd.getName());
                    contain = true;
                }
                ZipEntry newEntry = contain ? new ZipEntry(fileToAdd.getName()) : new ZipEntry("new/" + fileToAdd.getName());
                out.putNextEntry(newEntry);
                Files.copy(fileToAdd.toPath(), out);
                out.closeEntry();

                for (Map.Entry<String, ByteArrayOutputStream> outputStreamEntry : buffer.entrySet()) {
                    ZipEntry entry = new ZipEntry(outputStreamEntry.getKey());
                    out.putNextEntry(entry);
                    outputStreamEntry.getValue().writeTo(out);
                    out.closeEntry();
                }
            }


        }

    }
}
