package com.collectionframework.listinterface;
import java.util.ArrayList;
import java.util.List;


public class RotateElementsInList {

    public static  void  rotate(List<Integer>l1,int k){

        //add the list and put the position by which it wants to rotate
       // Collections.rotate(l1,3);
        k = k% l1.size();

        for(int j =0;j < k;j++){
            int first = l1.get(0);
            for(int i=0;i < l1.size()-1;i++){
                l1.set(i,l1.get(i+1));

            }
            l1.set(l1.size()-1,first);
        }

        System.out.println(l1);
    }



    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);
        System.out.println(l1);
        System.out.println("Enter k the number of times an array wants to be rotated");

        System.out.println("enter the k position");
        int k =3;
        rotate(l1,k);
    }


}
