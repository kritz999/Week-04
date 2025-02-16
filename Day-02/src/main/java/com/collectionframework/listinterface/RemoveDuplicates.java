package com.collectionframework.listinterface;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class RemoveDuplicates {

    public static void removeDup(List<Integer>l1){
        System.out.println(l1);

        ArrayList<Integer> l2 = new ArrayList<>();
        //using contains to check whether the element is present in the list or not
        for(int i : l1){
            if(!l2.contains(i)){
                l2.add(i);
            }


        }
        System.out.println(l2);
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        removeDup(l1);
    }
}
