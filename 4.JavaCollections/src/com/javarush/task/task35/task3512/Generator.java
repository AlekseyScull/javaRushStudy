package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> tClass;

    public Generator(Class<T> t) {
        this.tClass = t;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }
}
