package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private static Moon moon;

    private Moon() {}

    public static Moon getInstance() {
        if (moon == null) moon = new Moon();
        return moon;
    }
}
