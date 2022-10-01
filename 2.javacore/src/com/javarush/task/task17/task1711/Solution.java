package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length < 2) {
            throw new RuntimeException();
        }
        Person person;
        String name;
        Sex sex;
        Date bd;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        sex = args[i + 1].equals("м") ? Sex.MALE : Sex.FEMALE;
                        bd = format.parse(args[i + 2]);
                        if (sex == Sex.MALE) {
                            allPeople.add(Person.createMale(name, bd));
                        } else {
                            allPeople.add(Person.createFemale(name, bd));
                        }
                        System.out.print("id=" + allPeople.size());
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        sex = args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE;
                        person.setSex(sex);
                        person.setBirthDate(format.parse(args[i + 3]));
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + format2.format(person.getBirthDate()));
                    }
                }
                break;
        }
    }
}
