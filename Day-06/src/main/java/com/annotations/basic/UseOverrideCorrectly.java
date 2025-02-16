package com.annotations.basic;


class Animal{

    void makeSound(){
        System.out.println("makes sound");
    }
}

class Dog extends Animal{

    @Override
    void makeSound(){
        System.out.println("barks");
    }
}


public class UseOverrideCorrectly {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        a1.makeSound();
    }
}
