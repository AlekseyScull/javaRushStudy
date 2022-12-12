package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager statisticManager = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    public Map<String, Double> getAddsDailyProfit() {
        Map<String, Double> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                try {
                    result = (int)((format.parse(o2).getTime() - format.parse(o1).getTime()) / 100000);
                } catch (ParseException e) {}
                return result;
            }
        });
        for (EventDataRow eventDataRow : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)) {
            String keyDate = format.format(eventDataRow.getDate());
            double dayProfit = 0.;
            if (!map.containsKey(format.format(eventDataRow.getDate()))) {
                for (EventDataRow row : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)) {
                    if (keyDate.equals(format.format(row.getDate()))) {
                        dayProfit += ((VideoSelectedEventDataRow) row).getAmount() / 100.;
                    }
                }
                if (dayProfit != 0) map.put(keyDate, dayProfit);
            }
        }
        return map;
    }

    public Map<String, Map<String, Integer>> getCookWorkloadingMap() {
        Map<String, Map<String, Integer>> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                try {
                    result = (int)((format.parse(o2).getTime() - format.parse(o1).getTime()) / 100000);
                } catch (ParseException e) {}
                return result;
            }
        });
        for (EventDataRow event : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
            String keyDate = format.format(event.getDate());
            if (!map.containsKey(keyDate)) {
                Map<String, Integer> entryMap = new TreeMap<>();
                for (EventDataRow dataRow : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
                    if (keyDate.equals(format.format(dataRow.getDate()))) {
                        CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) dataRow;
                        String cookName = cookEvent.getCookName();
                        int cookTime = cookEvent.getTime();
                        if (!entryMap.containsKey(cookName)) {
                            entryMap.put(cookName, cookTime);
                        } else {
                            entryMap.replace(cookName, entryMap.get(cookName) + cookTime);
                        }
                    }
                }
                map.put(keyDate, entryMap);
            }
        }
        return map;
    }



    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType e : EventType.values()) {
                storage.put(e, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
