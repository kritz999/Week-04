package com.refection.advanceproblems;

public class MyService {
    // Fast method
    public void fastMethod() {
        System.out.println(" Fast Method Executed!");
    }

    // Slow method
    public void slowMethod() {
        try {
            Thread.sleep(3000);  // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⏳ Slow Method Executed!");
    }

    // Method with parameters
    public void addNumbers(int a, int b) {
        System.out.println("➕ Sum: " + (a + b));
    }
}
