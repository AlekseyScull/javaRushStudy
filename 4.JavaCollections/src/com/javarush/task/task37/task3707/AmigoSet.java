package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>((int) Math.max(16, Math.ceil(collection.size() / .75f)));
        addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(Object o) {
        if (this.map.containsKey((E) o)) return false;
        this.map.put((E) o, PRESENT);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() == 0) return false;
        for (Object o : c) {
            if (!add(o)) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public AmigoSet<E> clone() {
        AmigoSet<E> clone;
        try {
            clone = (AmigoSet<E>) super.clone();
            clone.map = (HashMap<E, Object>) this.map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return clone;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean equals(Object o) {
        AmigoSet<E> set = (AmigoSet<E>) o;
        return this.map.equals(set.map);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeInt(HashMapReflectionHelper.callHiddenMethod(this.map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(this.map, "loadFactor"));

        out.writeInt(map.size());

        for (E e : map.keySet())
            out.writeObject(e);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E)in.readObject(), PRESENT);
        }
    }
}
