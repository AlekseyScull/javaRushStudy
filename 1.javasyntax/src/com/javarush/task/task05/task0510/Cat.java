package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

import java.util.SplittableRandom;

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public void initialize(String name){
        this.name = name;
        this.age = 3;
        this.weight = 3;
        this.color = "grey";
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "grey";
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 3;
        this.color = "grey";
    }
    public void initialize(int weight, String color){
        this.age = 3;
        this.weight = weight;
        this.color = color;
    }
    public void initialize(int weight, String color, String address){
        this.age = 3;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

}
/*
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес (чужой домашний кот)
*/