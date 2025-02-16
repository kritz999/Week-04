package com.annotations.intermediatelevel;
import java.lang.annotation.*;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.FIELD) // Can only be applied to fields
@interface MaxLength {
    int value(); // Specifies the maximum allowed length
}


class User {

    @MaxLength(10) // Username cannot exceed 10 characters
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength(); // Validate username length
    }


    private void validateMaxLength() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                try {
                    field.setAccessible(true); // Allow access to private field
                    String fieldValue = (String) field.get(this);
                    if (fieldValue != null && fieldValue.length() > maxLength.value()) {
                        throw new IllegalArgumentException(
                                field.getName() + " exceeds max length of " + maxLength.value() + " characters!"
                        );
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}


public class AnnotationTest {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alice");
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("VeryLongUsername123");
            System.out.println("User created: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
