package com.exceptionhandling.throwvsthrows;

import java.util.Scanner;

public class ThrowVsThrows {

    public static double calculateInterest(double amount,double rate,int year){
       if(amount<0 && rate<0){
            throw new IllegalArgumentException("argument and rate must be positive");
       }
       return (amount*rate*year)/100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       try {
          double interest = calculateInterest(5000,2,1);
           System.out.println("Calculate interest "+interest);
       }catch(IllegalArgumentException e){
           System.out.println("The amount and rate must be positive");
        }
    }
}
