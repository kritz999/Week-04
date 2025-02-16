package com.annotations.advance;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.FIELD) // Can only be applied to fields
@interface JsonField {
    String name(); // Custom JSON key name
}

class user {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // Not annotated, so won't be serialized

    public user(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}


class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Class<?> objClass = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : objClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true); // Allow access to private fields
                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    jsonMap.put(jsonField.name(), field.get(obj).toString());
                }
            }

            return jsonMap.toString().replace("=", ": "); // Convert to JSON-like format

        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
public class JSONserialization {
    public static void main(String[] args) {
        user user = new user("Alice", 25, "secret123");
        String jsonOutput = JsonSerializer.serialize(user);
        System.out.println(jsonOutput);
    }
}
