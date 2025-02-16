package com.junittest.advancejunitpracticeproblem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {
    @Test
    void testValidDateFormat() {
        assertEquals("15-08-2023", DateFormatter.formatDate("2023-08-15"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
        assertEquals("31-12-1999", DateFormatter.formatDate("1999-12-31"));
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid Date Format", DateFormatter.formatDate("15-08-2023")); // Wrong format
        assertEquals("Invalid Date Format", DateFormatter.formatDate("2023/08/15")); // Wrong separator
        assertEquals("Invalid Date Format", DateFormatter.formatDate("abcd-ef-gh")); // Non-numeric
        assertEquals("Invalid Date Format", DateFormatter.formatDate("")); // Empty string
        assertEquals("Invalid Date Format", DateFormatter.formatDate(null)); // Null input
    }
}