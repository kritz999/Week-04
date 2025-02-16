package com.annotations.intermediatelevel;

import java.lang.reflect.Method;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface LogExecutionTime {
}


class ExecutionTimeLogger {
    public static void logExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime(); // Start time

                method.invoke(obj); // Invoke the method

                long endTime = System.nanoTime(); // End time
                long duration = endTime - startTime; // Calculate execution time

                System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class TaskProcessor {

    @LogExecutionTime
    public void fastTask() {
        System.out.println("Executing fast task...");
    }

    @LogExecutionTime
    public void slowTask() {
        System.out.println("Executing slow task...");
        try {
            Thread.sleep(500); // Simulate a delay of 500ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();

        ExecutionTimeLogger.logExecutionTime(processor, "fastTask");
        ExecutionTimeLogger.logExecutionTime(processor, "slowTask");
    }
}