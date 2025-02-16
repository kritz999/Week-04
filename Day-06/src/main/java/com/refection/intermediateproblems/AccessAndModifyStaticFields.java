package com.refection.intermediateproblems;

import java.lang.reflect.Field;

class Configuration {
    // Private static field
    private static String API_KEY = "DEFAULT_KEY";

    // Public method to get API_KEY (for verification)
    public static String getApiKey() {
        return API_KEY;
    }
}

public class AccessAndModifyStaticFields {

    public static void main(String[] args) {
        try {
            // Get the Class object of Configuration
            Class<?> cls = Configuration.class;

            // Get the private static field API_KEY
            Field field = cls.getDeclaredField("API_KEY");

            // Make the field accessible
            field.setAccessible(true);

            // Modify the static field value
            field.set(null, "NEW_SECRET_KEY");

            // Print the updated value
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

