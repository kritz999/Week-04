package com.junittest.advancejunitpracticeproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class UserRegistrationTest {
    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully", UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "SecurePass123"));
        assertEquals("User registered successfully", UserRegistration.registerUser("Alice", "alice@example.com", "Passw0rd!"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("", "john.doe@example.com", "SecurePass123");
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "12345");
        });
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "john.doe@example.com", "SecurePass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", null, "SecurePass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john.doe@example.com", null));
    }
}