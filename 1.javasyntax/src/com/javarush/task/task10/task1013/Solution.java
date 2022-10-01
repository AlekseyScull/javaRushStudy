package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private boolean sex;
        private int salary;
        private String address;

        public Human() {
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }


        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, int age, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age, boolean sex, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String firstName, String lastName, int age, boolean sex, int salary, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
            this.address = address;
        }

        public Human(boolean sex, String address) {
            this.sex = sex;
            this.address = address;
        }

        public Human(boolean sex, int salary) {
            this.sex = sex;
            this.salary = salary;
        }

        public Human(int age, int salary) {
            this.age = age;
            this.salary = salary;
        }

        public Human(int age, boolean sex) {
            this.age = age;
            this.sex = sex;
        }
    }
}
