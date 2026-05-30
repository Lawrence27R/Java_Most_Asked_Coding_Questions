package com.codes.java.codingquestions.strings;

public class StringReverser {

    public static String reverseWithPointers(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Swap the characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers towards the center
            left++;
            right--;
        }

        return new String(chars);
    }

    public static String reverseWithStringBuilder(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static void run() {

        String input = "Lawrence";

        System.out.println("Original String: " + input);

        System.out.println("Reversed String: "
                + reverseWithPointers(input));
    }
}
