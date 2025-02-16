package com.refection.advanceproblems;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;

    // Default constructor (needed for Reflection)
    public Person() {}

    // Method to display the values
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CreateACustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create an instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Loop through all fields of the class
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    // Get the field by name
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);  // Allow modification of private fields

                    // Set the field value
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
                }
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


