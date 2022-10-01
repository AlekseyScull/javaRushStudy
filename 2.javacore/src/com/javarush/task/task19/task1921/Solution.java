package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");
                StringBuilder birthDate = new StringBuilder();
                StringBuilder nameBuilder = new StringBuilder();
                for (String s : line) {
                    try {
                        birthDate.append(Integer.parseInt(s)).append(" ");
                    } catch (NumberFormatException ignored) {
                        nameBuilder.append(s).append(" ");
                    }
                }
                String name = nameBuilder.toString().trim();
                Date date = simpleDateFormat.parse(birthDate.toString());
                PEOPLE.add(new Person(name, date));
            }
        }
        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " " + simpleDateFormat.format(person.getBirthDate()));
        }

    }
}

