package com.collectionframework.listinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class ReverseList {
    public static void reverseList(List<Integer>num){
        int first=0;
        int last = num.size()-1;
        while(first<last){

           int temp = num.get(first);
           num.set(first,num.get(last));
           num.set(last,temp);

            first++;
            last--;
        }

    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer>l1){

        LinkedList<Integer> reversedList = new LinkedList<>();
        for(int i = l1.size()-1;i>0;i--){
            reversedList.add(l1.get(i));
        }
        return reversedList;

    }

    public static void main(String[] args) {
        List<Integer> num  = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        System.out.println("The original elements are :"+num);

       /* Collections.reverse(num);
        System.out.println("The reversed list :"+num);*/

        reverseList(num);
        System.out.println("Reversed list is:"+num);

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

       LinkedList<Integer> reversedList = reverseLinkedList(l1);
        System.out.println("reversed linked list :"+reversedList);
    }
}
