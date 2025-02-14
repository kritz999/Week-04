package com.exceptionhandling.customexception;
import java.util.*;
public class CustomException {

    static class InvalidAgeException extends Exception{
        public InvalidAgeException(String message){
            super(message);
        }

    }
        // this method will throw invalid age exception
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            //this will throws a custom exception
            // this stops the execution immediately
            throw new InvalidAgeException("age must be 18 or above");
        }else{
            System.out.println("Access granted");
        }

    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int age = sc.nextInt();
            validateAge(age);
        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Please enter a valid age");
        }
    }
}
