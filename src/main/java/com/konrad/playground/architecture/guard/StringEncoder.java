package com.konrad.playground.architecture.guard;

public class StringEncoder {

    public String encodeString(String s) {
        validateInput(s);

        StringBuilder result = new StringBuilder();

        var current = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                appendCurrentToResult(count, result, current);
                count = 1;
                current = s.charAt(i);
            }
        }
        return appendCurrentToResult(count, result, current);
    }

    private static void validateInput(String s) {
        if (s == null) {
            throw new NullPointerException("String can't be null!");
        }
        if (s.length() <= 5 || s.length() >= 100) {
            throw new IllegalArgumentException("The size of the string should be between 6 and 99. Was: %d".formatted(s.length()));
        }
        if (containsNumbers(s)) {
            throw new IllegalArgumentException("String contains numbers: %s".formatted(s));
        }
    }

    private static String appendCurrentToResult(int count, StringBuilder result, char current) {
        if (count == 1) {
            result.append(current);
        } else {
            result.append(current).append(count);
        }
        return result.toString();
    }

    private static boolean containsNumbers(String s) {
        return s.matches(".*\\d.*");
    }
}
