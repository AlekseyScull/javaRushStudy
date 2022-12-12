package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private int maxProfit = 0;
    private long amount = 0;
    private int totalDuration = 0;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();
        storage.list().sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
                double difCostPerSecond = o2.getAmountPerOneDisplaying() / (double) o2.getDuration() - o1.getAmountPerOneDisplaying() / (double) o1.getDuration();
                return result != 0 ? result : (int) difCostPerSecond;
            }
        });
        List<Advertisement> list = new ArrayList<>();
        selectVideo(timeSeconds, list);
        for (Advertisement a : list) {
            amount += a.getAmountPerOneDisplaying();
            totalDuration += a.getDuration();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(list, amount, totalDuration));
        for (Advertisement a : list) {
            a.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", a.getName(), a.getAmountPerOneDisplaying(), (a.getAmountPerOneDisplaying() * 1000)/ a.getDuration()));
        }
    }

    private void selectVideo(int targetTime, List<Advertisement> adList) {
        if (adList.size() == storage.list().size())
            return;

        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getDuration() <= targetTime && !adList.contains(advertisement) && advertisement.getHits() > 0) {
                adList.add(advertisement);
                int totalDuration = 0;
                int totalProfit = 0;
                for (Advertisement a : adList) {
                    totalDuration += a.getDuration();
                    totalProfit += a.getAmountPerOneDisplaying();
                }
                if (totalProfit > maxProfit && timeSeconds > totalDuration) {
                    maxProfit = totalProfit;
                    selectVideo(timeSeconds - totalDuration, adList);
                } else if (totalProfit < maxProfit || timeSeconds < totalDuration)
                    adList.remove(adList.size() - 1);
            }
        }
    }
}
