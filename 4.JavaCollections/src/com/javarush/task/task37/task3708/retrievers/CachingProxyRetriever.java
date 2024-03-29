package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private OriginalRetriever retriever;
    private LRUCache cache;

    public CachingProxyRetriever(Storage storage) {
        this.retriever = new OriginalRetriever(storage);
        this.cache = new LRUCache<>(10);
    }

    @Override
    public Object retrieve(long id) {
        Object o = cache.find(id);
        if (o != null) return o;
        o = retriever.retrieve(id);
        cache.set(id, o);
        return o;
    }
}
