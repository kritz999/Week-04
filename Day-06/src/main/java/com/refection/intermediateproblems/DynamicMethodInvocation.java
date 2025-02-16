package com.refection.intermediateproblems;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public int multiply(int a, int b) {
        return a * b;
    }
}



public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Take method name as input
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Take two numbers as input
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Load the MathOperations class dynamically
            Class<?> cls = MathOperations.class;

            // Create an instance of MathOperations
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get the method dynamically based on user input
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            Object result = method.invoke(obj, num1, num2);

            // Print result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
