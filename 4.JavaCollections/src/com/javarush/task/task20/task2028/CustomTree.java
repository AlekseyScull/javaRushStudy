package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    List<Entry<String>> tree = new LinkedList<>();

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }

    protected CustomTree() {
        this.root = new Entry<>("0");
        this.root.parent = root;
        this.tree.add(root);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void treeCheck() {
        boolean check = false;
        for (Entry<String> entry : this.tree) {
            if (entry.isAvailableToAddChildren()) {
                check = true;
                break;
            }
        }
        if (!check) {
            for (Entry<String> entry : this.tree) {
                if (entry.leftChild == null && entry.rightChild == null) {
                    entry.availableToAddLeftChildren = true;
                    entry.availableToAddRightChildren = true;
                }
            }
        }
    }

    @Override
    public boolean add(String elementName) {
        boolean added = false;
        Entry<String> e = new Entry<>(elementName);
        treeCheck();
        for (Entry<String> entry : this.tree) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    e.parent = entry;
                    tree.add(e);
                    added = true;
                    entry.leftChild = e;
                    entry.availableToAddLeftChildren = false;
                    break;
                } else {
                    e.parent = entry;
                    tree.add(e);
                    added = true;
                    entry.rightChild = e;
                    entry.availableToAddRightChildren = false;
                    break;
                }
            }
        }
        return added;
    }

    public Entry<String> getEntry(String elementName) {
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(elementName)) return entry;
        }
        return null;
    }

    public String getParent(String elementName) {
        if (getEntry(elementName) != null) return getEntry(elementName).parent.elementName;
        return null;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        Entry<String> element = getEntry((String) o);
        if (tree.contains(element)) {
            if (element.parent.leftChild == element) {
                element.parent.leftChild = null;
            } else element.parent.rightChild = null;
            if (element.leftChild != null) remove(element.leftChild.elementName);
            if (element.rightChild != null) remove(element.rightChild.elementName);
            tree.remove(element);
            return true;
        } else return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
