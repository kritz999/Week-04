package com.collectionframework.setinterface;
import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference {

    public static Set<Integer> SymmetricDifferences(Set<Integer>s1,Set<Integer>s2){
      Set<Integer> s = new HashSet<>(s1);
      for(Integer i: s2){
          if(!s.contains(i)){
              s.add(i);
          }
      }

        return s;
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
        // {1,2,3} {3,4,5} = o/p {1,2,4,5}

        System.out.println("symmetric diffrence"+SymmetricDifferences(s1,s2));
    }
}
