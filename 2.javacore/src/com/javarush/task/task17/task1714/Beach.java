package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int result = 0;
        result = this.getDistance() < beach.getDistance() ? result + 1 : result - 1;
        if (this.getDistance() == beach.getDistance()) result = 0;
        if (this.getQuality() == beach.getQuality()) result = 0;
        else if (this.getQuality() > beach.getQuality()) {result += 1;} else result -= 1;

        return result;
    }
}
