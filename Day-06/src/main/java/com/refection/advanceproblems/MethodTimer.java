package com.refection.advanceproblems;

import java.lang.reflect.Method;

public class MethodTimer{
        // Measure execution time of any method using Reflection
        public static void measureMethodTime(Object obj, String methodName, Object... args) {
            try {
                // Get class reference
                Class<?> clazz = obj.getClass();

                // Get argument types to locate method
                Class<?>[] parameterTypes = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    parameterTypes[i] = args[i].getClass();

                    // Handle primitive types
                    if (parameterTypes[i] == Integer.class) {
                        parameterTypes[i] = int.class;
                    }
                }

                // Find method using Reflection
                Method method = clazz.getMethod(methodName, parameterTypes);

                // Measure start time
                long startTime = System.nanoTime();

                // Invoke the method
                method.invoke(obj, args);

                // Measure end time
                long endTime = System.nanoTime();

                // Calculate execution time in milliseconds
                long duration = (endTime - startTime) / 1_000_000;

                // Output the execution time
                System.out.println("⏱ Execution time of " + methodName + "(): " + duration + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
