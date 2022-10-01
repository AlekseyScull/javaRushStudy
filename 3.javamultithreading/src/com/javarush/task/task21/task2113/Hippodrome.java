package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Apple", 3, 0));
        horseList.add(new Horse("Spirit", 3, 0));
        horseList.add(new Horse("Donna", 3, 0));
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.print("\n \n \n \n \n \n \n \n \n \n");
    }

    public Horse getWinner() {
        double distMax = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > distMax) {
                distMax = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
