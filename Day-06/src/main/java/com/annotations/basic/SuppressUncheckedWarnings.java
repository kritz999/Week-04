package com.annotations.basic;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {
    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        ArrayList l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add("hello");
        System.out.println(l1);


    }
}
