package com.javarush.task.task20.task2007;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/

public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        JavaRush javaRush = new JavaRush();
        User user = new User();
        user.setLastName("B");
        user.setLastName("A");
        user.setBirthDate(new Date());
        user.setMale(true);
        user.setCountry(User.Country.RUSSIA);
        javaRush.users.add(user);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\ANNA\\Desktop\\test2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(javaRush);
    }
}
