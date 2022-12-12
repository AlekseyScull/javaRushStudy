package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private LinkedBlockingQueue<Order> queue;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
            startVideoAndCooking(order);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    private void startVideoAndCooking(Order order) {
        try {
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        ConsoleHelper.writeMessage(order.toString());
        if (!order.isEmpty()) {
            queue.add(order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createTestOrder() {
        try {
            TestOrder order = new TestOrder(this);
            startVideoAndCooking(order);
        } catch (IOException e) {
        }
    }
}
