package com.collectionframework.setinterface;

import java.util.HashSet;
import java.util.Set;

public class Subsets {

    public static boolean subset(Set<Integer>s1,Set<Integer>s2){

        return s2.containsAll(s1);
    }



    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(2);
        s1.add(3);

        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(4);

        System.out.println( subset(s1,s2));
    }
}
