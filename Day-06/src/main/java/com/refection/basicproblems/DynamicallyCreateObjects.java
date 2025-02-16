package com.refection.basicproblems;
import java.lang.reflect.Method;
import java.util.*;
class Student{
    private String name;

    public Student(){
        this.name = "default student";

    }

    public void display(){

        System.out.println("Student name :"+name);
    }

}


public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try{

            Class<?> cls = Class.forName("mypackage.Student");
            Object obj = cls.getDeclaredConstructor().newInstance();

            cls.getMethod("display").invoke(obj);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
