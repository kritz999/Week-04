package com.collectionframework.setinterface;

import java.util.HashSet;
import java.util.Set;
public class UnionAndInterseactionOfSet {

    public static void intersection(Set<Integer>s1,Set<Integer>s2){
        Set<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);

        System.out.println("Intersection of list :"+ intersection);
    }




    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        Set<Integer> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);
        s2.add(5);

        //union of 2 sets
        s1.addAll(s2);
        System.out.println("union"+s1);

        //intersection
        intersection(s1,s2);
    }
}
