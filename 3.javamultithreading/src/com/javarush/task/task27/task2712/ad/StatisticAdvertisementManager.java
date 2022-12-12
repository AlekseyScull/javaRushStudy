package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager statisticAdManager = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        return statisticAdManager;
    }

    public List<Advertisement> getAdList(boolean hasHits) {
        List<Advertisement> list = new ArrayList<>();
        if (hasHits) {
            for (Advertisement a : storage.list()) {
                if (a.getHits() > 0) list.add(a);
            }
        } else {
            for (Advertisement a : storage.list()) {
                if (a.getHits() == 0) list.add(a);
            }
        }
        return list;
    }
}
