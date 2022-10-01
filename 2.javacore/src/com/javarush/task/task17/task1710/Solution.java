package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        //напишите тут ваш код

        Person person;
        switch (args[0]) {
            case "-c":
                try {
                    if (args[2].equals("м")) {
                        allPeople.add(Person.createMale(args[1], format.parse(args[3])));
                    } else if (args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1], format.parse(args[3])));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("id=" + (allPeople.size() - 1));
                break;
            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + format2.format(person.getBirthDate()));
                break;
            case "-u":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                try {
                    person.setBirthDate(format.parse(args[4]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.set(Integer.parseInt(args[1]), person);
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
            default:
        }
    }
}
