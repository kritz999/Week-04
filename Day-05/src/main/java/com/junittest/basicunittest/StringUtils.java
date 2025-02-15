package com.junittest.basicunittest;

public class StringUtils {
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check if a string is a palindrome
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase(); // Remove spaces, ignore case
        return cleanedStr.equals(new StringBuilder(cleanedStr).reverse().toString());
    }

    // Method to convert a string to uppercase
    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}
