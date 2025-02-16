package com.collectionframework.listinterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NthElementFromEnd {

    public static String NthElementFromEnd(LinkedList<String>l1,int k){

        if(l1==null|| l1.isEmpty()|| k<=0){
            return "invalid input";
        }

        var fast = l1.iterator();
        var slow = l1.iterator();

        for(int i=0;i<k;i++){
            if(!fast.hasNext()){
                return "invalid input";
            }

                fast.next();

        }

        while(fast.hasNext()){
            slow.next();
            fast.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> l1 = new LinkedList<>();
        l1.add("A");
        l1.add("B");
        l1.add("C");
        l1.add("D");
        l1.add("E");
        System.out.println("Enter the position you want to rotate");
        int k = sc.nextInt();
        String result = NthElementFromEnd(l1,k);
        System.out.println("The "+k+ "th element from the end is "+result);
    }
}
