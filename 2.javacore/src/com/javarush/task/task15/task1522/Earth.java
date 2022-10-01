package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private static Earth earth;

    private Earth() {}

    public static Earth getInstance() {
        if (earth == null) earth = new Earth();
        return earth;
    }

}
