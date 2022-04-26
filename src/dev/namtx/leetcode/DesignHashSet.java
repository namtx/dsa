package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignHashSet {
    List<List<Integer>> list;

    public DesignHashSet() {
        list = new ArrayList<>(1<<15-1);
    }

    public void add(int key) {
        int h = hash(key);
        list = new ArrayList<>(1<<15-1);
        if (list.size() <= h) {
            list.add(new ArrayList<>());
        }
        list.get(h).add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        if (list.get(h).contains(key)) {
            list.get(h).remove(key);
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        if (list.size() <= h) {
            return false;
        }
        return list.get(h).contains(key);
    }

    private int hash(int key) {
        return ((key * 1031237) & (1<< 20)-1)>>5;
    }

    public static void main(String[] args) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(2));
        System.out.println(hashSet.contains(3));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
