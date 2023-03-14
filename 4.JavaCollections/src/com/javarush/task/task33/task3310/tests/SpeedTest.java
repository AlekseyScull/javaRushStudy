package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = System.currentTimeMillis();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return System.currentTimeMillis() - start;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = System.currentTimeMillis();
        for (long id : ids) {
            strings.add(shortener.getString(id));
        }
        return System.currentTimeMillis() - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long timeShortener1 = getTimeToGetIds(shortener1, origStrings, ids);
        long timeShortener2 = getTimeToGetIds(shortener2, origStrings, ids);
        Assert.assertTrue(timeShortener1 > timeShortener2);
        timeShortener1 = getTimeToGetStrings(shortener1,ids, strings);
        timeShortener2 = getTimeToGetStrings(shortener2,ids, strings);
        Assert.assertEquals(timeShortener1, timeShortener2, 30);

    }
}
