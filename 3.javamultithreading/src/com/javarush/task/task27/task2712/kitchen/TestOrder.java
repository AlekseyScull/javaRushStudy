package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        this.dishes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.dishes.add(Dish.values()[(int)(Math.random() * 5)]);
        }
    }
}
