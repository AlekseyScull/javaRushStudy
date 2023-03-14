package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 16);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String string : strings) {
            result.add(shortener.getId(string));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementNumber) {
        Helper.printMessage("StorageStrategy name: " + strategy.getClass().getSimpleName());
        Shortener shortener = new Shortener(strategy);
        Set<String> strings = new HashSet<>();
        Set<Long> longs = new HashSet<>();
        for (long i = 0; i < elementNumber; i++) {
            String rgs = Helper.generateRandomString();
            strings.add(rgs);
            shortener.getId(rgs);
        }
        long start = getTime();
        longs = getIds(shortener, strings);
        long end = getTime();
        Helper.printMessage("getIds execution time " + (end - start));
        start = getTime();
        getStrings(shortener, longs);
        end = getTime();
        Helper.printMessage("getStrings execution time " + (end - start));
        String test = getStrings(shortener, longs).equals(strings) ? "Тест пройден." : "Тест не пройден.";
        Helper.printMessage(test);

    }

    private static long getTime() {
        return new Date().getTime();
    }

}
