package com.refection.advanceproblems;

import java.util.HashMap;
import java.util.Map;

public class TestObjectMapper {
    public static void main(String[] args) {
        // Create a map with field names and values
        Map<String, Object> personData = new HashMap<>();
        personData.put("name", "Alice");
        personData.put("age", 25);

        // Convert map to object
        Person person = CreateACustomObjectMapper.toObject(Person.class, personData);

        // Display the populated object
        if (person != null) {
            person.display();  // Output: Name: Alice, Age: 25
        }
    }

}
