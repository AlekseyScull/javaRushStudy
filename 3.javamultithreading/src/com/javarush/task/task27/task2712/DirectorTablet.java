package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        double total = 0.00;
        Map<String, Double> map = StatisticManager.getInstance().getAddsDailyProfit();
        for (Map.Entry<String, Double> e : map.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %.2f", e.getKey(), e.getValue()));
            total += e.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkloadingMap();
        for (Map.Entry<String, Map<String, Integer>> mapEntry : map.entrySet()) {
            ConsoleHelper.writeMessage(mapEntry.getKey());
            for (Map.Entry<String, Integer> entry : mapEntry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", entry.getKey(), Math.round(entry.getValue() / 60)));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getAdList(true);
        list.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }
    public void printArchivedVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getAdList(false);
        list.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }

}
