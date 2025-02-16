package com.collectionframework.listinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class FindFrequencyOfElements {
    //function that returns hashmap
    public static  HashMap<String,Integer> countfrequency(List<String>l1){

        HashMap<String,Integer> freq = new HashMap<>();
        for(String words: l1){

           freq.put(words,freq.getOrDefault(words,0)+1);

        }
            return freq;

    }



   public static void main(String[] args) {
       HashMap<String,Integer>hm = new HashMap<>();

        List<String>l1 = new ArrayList<>();

        l1.add("apple");
        l1.add("banana");
        l1.add("apple");
        l1.add("orange");

        System.out.println(l1);


        HashMap<String,Integer> h1 =  countfrequency(l1);
       System.out.println(h1);

    }
}
