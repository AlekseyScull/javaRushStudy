package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String str) {
        if (storageStrategy.containsValue(str)) return storageStrategy.getKey(str);
        lastId++;
        storageStrategy.put(lastId, str);
        return lastId;
    }
    public synchronized String getString(Long id) {return storageStrategy.getValue(id);}
}
