package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int passengersCount;
    @Override
    public void fly() {

    }

    public Plane(int passengersCount) {
        this.passengersCount = passengersCount;
    }
}
