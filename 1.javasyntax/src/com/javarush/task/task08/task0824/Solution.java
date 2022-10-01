package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human children1 = new Human("name", true, 30);
        Human children2 = new Human("name", true, 25);
        Human children3 = new Human("name", true, 20);
        Human father = new Human("name", true, 60, children1, children2, children3);
        Human mother = new Human("name", false, 60, children1, children2, children3);
        Human grandpaFather = new Human("name", true, 90, father);
        Human grandpaMother = new Human("name", true, 90, father);
        Human grandmaFather = new Human("name", false, 88, mother);
        Human grandmaMother = new Human("name", false, 88, mother);
        System.out.println(grandmaFather);
        System.out.println(grandpaFather);
        System.out.println(grandmaMother);
        System.out.println(grandpaMother);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, Boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, Boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            Collections.addAll(this.children, children);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
