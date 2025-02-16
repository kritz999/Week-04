package com.refection.advanceproblems;


import java.lang.reflect.Method;


public class MethodExecutionTiming  {
    public static void main(String[] args) {
        // Create an instance of MyService
        MyService service = new MyService();

        // Measure the execution time of various methods
        MethodTimer.measureMethodTime(service, "fastMethod");
        MethodTimer.measureMethodTime(service, "slowMethod");
        MethodTimer.measureMethodTime(service, "addNumbers", 10, 20);
    }
}
