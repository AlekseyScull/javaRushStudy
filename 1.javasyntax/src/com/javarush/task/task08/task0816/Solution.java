package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));
        map.put("Ivanov", dateFormat.parse("JUNE 1 2012"));
        map.put("Petrov", dateFormat.parse("JULY 1 2012"));
        map.put("Sidorov", dateFormat.parse("AUGUST 1 2012"));
        map.put("Vasechkin", dateFormat.parse("September 1 2012"));
        map.put("Pupkin", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Evdokimov", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Kozlov", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Utkin", dateFormat.parse("JANUARY 1 2012"));
        map.put("Petrova", dateFormat.parse("FEBRUARY 1 2012"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Map<String, Date> copyMap = new HashMap<>(map);
        for (Map.Entry<String, Date> entry : copyMap.entrySet()) {
            if (entry.getValue().getMonth() >= 5 && entry.getValue().getMonth() <= 7) {
                map.remove(entry.getKey());
            }
        }
    }

    public static void main(String[] args) throws ParseException {

    }
}
