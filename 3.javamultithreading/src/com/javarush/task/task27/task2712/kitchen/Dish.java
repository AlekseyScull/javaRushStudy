package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish value : Dish.values()) {
            if (Dish.values()[Dish.values().length - 1] != value) {
                sb.append(value).append(", ");
            } else {
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
