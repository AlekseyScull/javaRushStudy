package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String fileName = file.getFileName().toString();
        int fileSize = content.length;
        boolean match = true;
        if (partOfName != null) match = fileName.contains(partOfName) && match;
        if (partOfContent != null && match) {
            for (String line : Files.readAllLines(file)) {
                if (line.contains(partOfContent)){
                    match = true;
                    break;
                } else match = false;
            }
        }
        if (minSize > 0) match = fileSize > minSize && match;
        if (maxSize > 0) match = fileSize < maxSize & match;
        if (match) foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}
