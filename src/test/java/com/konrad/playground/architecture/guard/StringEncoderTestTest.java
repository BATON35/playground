package com.konrad.playground.architecture.guard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEncoderTest {
    private final StringEncoder encoder = new StringEncoder();

    @Test
    void shouldEncodeStringCorrectly() {
        String result = encoder.encodeString("aaabbcf");
        assertEquals("a3b2cf", result);
    }

    @Test
    void shouldEncodeStringCorrectlyd() {
        String result = encoder.encodeString("aaabbcffff");
        assertEquals("a3b2cf4", result);
    }

    @Test
    void shouldThrowExceptionForNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            encoder.encodeString("123456");
        });
        assertEquals("String contains numbers: 123456", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNumberInsideLetters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            encoder.encodeString("adddf1ffff");
        });
        assertEquals("String contains numbers: adddf1ffff", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullInput() {
        assertThrows(NullPointerException.class, () -> encoder.encodeString(null));
    }

    @Test
    void shouldThrowExceptionForShortString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            encoder.encodeString("abc");
        });
        assertTrue(exception.getMessage().contains("The size of the string should be between"));
    }
}