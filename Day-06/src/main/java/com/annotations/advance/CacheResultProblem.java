package com.annotations.advance;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.METHOD) // Can only be applied to methods
@interface CacheResult {}


class ExpensiveService {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult // Apply caching to this method
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }

        System.out.println("Computing square of: " + number);
        int result = number * number;

        cache.put(number, result); // Store result in cache
        return result;
    }
}


public class CacheResultProblem {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        // First call - computation occurs
        System.out.println("Result: " + service.computeSquare(5));

        // Second call with same input - should return cached result
        System.out.println("Result: " + service.computeSquare(5));

        // New input - computation occurs again
        System.out.println("Result: " + service.computeSquare(10));

        // Cached result for 10 should be returned
        System.out.println("Result: " + service.computeSquare(10));
    }
}
