package com.exceptionhandling.finallyblock;
import java.util.Scanner;
import java.util.Scanner;

public class FinallyBlockExecution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("enter 1st input ");
            int n1 = sc.nextInt();

            System.out.println("enter 2nd input");
            int n2 = sc.nextInt();

            double div = n1/n2;
        }catch(ArithmeticException e){
            System.out.println("error the number cannot be divided by zero");
        }finally{
            System.out.println("operation completed");
            sc.close();
        }
    }
}
