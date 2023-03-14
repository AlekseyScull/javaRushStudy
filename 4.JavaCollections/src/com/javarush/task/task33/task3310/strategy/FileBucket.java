package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(this.path);
            Files.createFile(this.path);
            this.path.toFile().deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize() {
        long l = 0;
        try {
            l = Files.size(this.path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return l;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(this.path))) {
            oos.writeObject(entry);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() != 0) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(this.path))) {
                return (Entry) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(this.path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
