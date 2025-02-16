package com.collectionframework.setinterface;
import java.util.HashSet;
import java.util.Set;
public class CheckIfTwoSetsAreEqual {

//duplicate elements are not found
    public static boolean Equals(Set<Integer>s, Set<Integer>b){

        if(s.equals(b)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);

        Set<Integer> b = new HashSet<>();
        b.add(3);
        b.add(2);
        b.add(1);

        System.out.println( Equals(s,b));
    }
}
