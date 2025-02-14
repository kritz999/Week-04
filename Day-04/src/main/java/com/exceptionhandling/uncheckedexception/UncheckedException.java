package com.exceptionhandling.uncheckedexception;
import java.util.*;
public class UncheckedException {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        try{

            System.out.println("enter num 1 ");
            int n1 = sc.nextInt();

            System.out.println("enter num 2 ");
            int n2 = sc.nextInt();

            int result = n1/n2;
            System.out.println("result "+result);
        }catch(ArithmeticException e){
            System.out.println("ArithmeticException caught :"+ e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("Input mismatch exception occurred "+ e.getMessage());
        }


    }
}
