package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;

    //напишите тут ваш код
    Cat() {
        catCount++;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        catCount--;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            Cat cat = new Cat();
        }
        System.out.println(Cat.catCount);

    }
}