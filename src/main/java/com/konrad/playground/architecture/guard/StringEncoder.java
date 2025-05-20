package com.konrad.playground.architecture.guard;
public class StringEncoder {

    public String encodeString(String s) {
        StringBuilder result = new StringBuilder();
        if (s != null) {
            if (s.length() > 5 && s.length() < 100) {
                if (!s.matches(".*\\d.*")) {
                    var current = s.charAt(0);
                    int count = 1;
                    for (int i = 1; i < s.length(); i++) {
                        if (s.charAt(i) == current) {
                            count++;
                        } else {
                            if (count == 1) {
                                result.append(current);
                            } else {
                                result.append(current).append(count);
                            }
                            count = 1;
                            current = s.charAt(i);
                        }
                    }
                    if (count == 1) {
                        result.append(current);
                    } else {
                        result.append(current).append(count);
                    }
                } else {
                    throw new IllegalArgumentException("String contains numbers: %s".formatted(s));
                }
            } else {
                throw new IllegalArgumentException("The size of the string should be between 6 and 99. Was: %d".formatted(s.length()));
            }
        } else {
            throw new NullPointerException("String can't be null!");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        var stringEncoder = new StringEncoder();
        System.out.println(stringEncoder.encodeString("aaaaabbbaaacccc"));
    }
}
