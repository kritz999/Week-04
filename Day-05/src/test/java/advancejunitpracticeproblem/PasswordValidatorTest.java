package com.junittest.advancejunitpracticeproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PasswordValidatorTest {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValidPassword("Secure123"), "Valid password should pass.");
        assertTrue(PasswordValidator.isValidPassword("HelloWorld9"), "Valid password should pass.");
        assertTrue(PasswordValidator.isValidPassword("TestPassword1"), "Valid password should pass.");
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValidPassword("short"), "Too short, should fail.");
        assertFalse(PasswordValidator.isValidPassword("nouppercase1"), "No uppercase letter, should fail.");
        assertFalse(PasswordValidator.isValidPassword("NOLOWERCASE1"), "No lowercase letter, should fail.");
        assertFalse(PasswordValidator.isValidPassword("NoNumberHere"), "No digit, should fail.");
        assertFalse(PasswordValidator.isValidPassword(null), "Null password should fail.");
        assertFalse(PasswordValidator.isValidPassword(""), "Empty password should fail.");
    }
}