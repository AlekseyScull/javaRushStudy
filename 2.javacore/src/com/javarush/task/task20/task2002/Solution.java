package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("test", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                user.setFirstName("Aleks");
                user.setLastName("C");
                user.setBirthDate(format.parse("14/10/1992"));
                user.setMale(true);
                user.setCountry(User.Country.RUSSIA);
            }
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream ps = new PrintStream(outputStream);
            ps.println(this.users.size());
            for (User user : this.users) {
                ps.println(user.getFirstName());
                ps.println(user.getLastName());
                ps.println(user.getBirthDate().getTime());
                ps.println(user.isMale());
                ps.println(user.getCountry());
            }
            ps.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(fileReader.readLine());
            for (int i = 0; i < count; i++) {
                User user = new User();
                {
                    user.setFirstName(fileReader.readLine());
                    user.setLastName(fileReader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(fileReader.readLine())));
                    user.setMale(fileReader.readLine().equals("true"));
                    switch (fileReader.readLine()) {
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        default:
                            user.setCountry(User.Country.OTHER);
                    }
                }
                users.add(user);
            }
            fileReader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
