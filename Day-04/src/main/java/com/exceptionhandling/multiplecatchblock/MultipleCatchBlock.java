package com.exceptionhandling.multiplecatchblock;

import java.util.Scanner;

public class MultipleCatchBlock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = null; //to test null pointer exception

        try{
            arr = new int[3];

            System.out.println("Enter "+ arr.length +"element :");
            for(int i =0;i<arr.length;i++){
                arr[i]= sc.nextInt();
            }
            System.out.println("Enter index");
            int i = sc.nextInt();
            System.out.println(" value at "+ i +" is  "+ arr[i]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index ");
        }catch(NullPointerException e){
            System.out.println("Array is not initialized ");
        }finally{
            sc.close();
        }
    }


}
