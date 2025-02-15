package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUnitsTest {
    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9}) // Test multiple values
    void testIsEven(int number) {
        boolean expected = (number % 2 == 0);
        assertEquals(expected, numberUtils.isEven(number),
                "Failed for number: " + number);
    }
}