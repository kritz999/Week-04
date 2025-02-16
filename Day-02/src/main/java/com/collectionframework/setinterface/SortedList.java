package com.collectionframework.setinterface;

import java.util.*;

public class SortedList {

    public static void main(String[] args) {
        HashSet<Integer> l1 = new HashSet<>();
        l1.add(5);
        l1.add(3);
        l1.add(9);
        l1.add(1);
        List<Integer> list = new ArrayList<>(l1);
        Collections.sort(list);
        System.out.println(list);
    }
}
