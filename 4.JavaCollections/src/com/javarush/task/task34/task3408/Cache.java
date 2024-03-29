package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (!cache.containsKey(key)) {
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            V value = constructor.newInstance(key);
            cache.put(key, value);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method m = obj.getClass().getDeclaredMethod("getKey");
            m.setAccessible(true);
            K k = (K) m.invoke(obj);
            cache.put(k, obj);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {}
        return false;
    }

    public int size() {
        return cache.size();
    }
}
