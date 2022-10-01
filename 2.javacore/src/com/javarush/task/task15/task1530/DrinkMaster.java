package com.javarush.task.task15.task1530;

public abstract class DrinkMaster {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
