package com.refection.basicproblems;

import java.lang.reflect.Field;

class Person{
    
    private int age;
    
    public Person(int age){
        this.age = age;
    }
    public void displayAge(){
        System.out.println("Age:" +age);
    }
    
}


public class AcessPrivateField {
    public static void main(String[] args) {
        try{
            Person person = new Person(25);
            person.displayAge();

            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);


            ageField.set(person, 30);


            int newAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + newAge);


            person.displayAge();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();



        }
    }
}
