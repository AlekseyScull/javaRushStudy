package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandpa);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandma);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent1;
        private Cat parent2;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent1 = parent;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.parent1 = mother;
            this.parent2 = father;
        }

        @Override
        public String toString() {
            if (parent1 == null && parent2 == null) {
                return "The cat's name is " + name + ", no mother " + ", no father";
            } else if (parent1 != null && parent2 == null) {
                return "The cat's name is " + name + ", mother is " + parent1.name + ", no father";
            } else if (parent1 == null) {
                return "The cat's name is " + name + ", no mother " + ", father is " + parent2.name;
            } else {
                return "The cat's name is " + name + ", mother is " + parent1.name + ", father is " + parent2.name;
            }
        }
    }

}
