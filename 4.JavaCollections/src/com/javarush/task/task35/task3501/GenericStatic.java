package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <T>T someStaticMethod(T t) {
        System.out.println(t);
        return t;
    }
}
