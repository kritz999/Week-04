package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testReverse() {
        assertEquals("olleH", stringUtils.reverse("Hello"));
        assertEquals("avaJ", stringUtils.reverse("Java"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null)); // Edge case: Null input
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("Able was I saw Elba")); // Case insensitive, spaces ignored
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null)); // Edge case: Null input
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
        assertEquals("", stringUtils.toUpperCase("")); // Edge case: Empty string
        assertNull(stringUtils.toUpperCase(null)); // Edge case: Null input

    }
    }