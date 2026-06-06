package com.codes.java;

import java.util.*;

public class StringQuestionsCode {

//    Reverse a String
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

//    Find Duplicates characters
    public static Set<Character> findDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Character> seen = new HashSet<>();
        // LinkedHashSet keeps the order in which duplicates are discovered
        Set<Character> duplicates = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // If the character cannot be added to 'seen', it means it's a duplicate
            if (!seen.add(c)) {
                duplicates.add(c);
            }
        }
        return duplicates;
    }

//    Remove Duplicate Characters
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Assuming ASCII characters. Use a Set<Character> if Unicode is required.
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen[c]) {
                seen[c] = true;   // Mark as seen
                sb.append(c);     // Append to our unique result sequence
            }
        }
        return sb.toString();
    }

//    Count Character Frequency
    public static Map<Character, Integer> count(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap(); // Safe, immutable empty map
        }

        // Using LinkedHashMap to maintain the insertion order of characters
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // getOrDefault handles the null check if the key doesn't exist yet
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }

//    Anagram Checker silent, listen
    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Assuming ASCII characters. Use HashMap if Unicode is required.
        int[] charCounts = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i)]++;
            charCounts[s2.charAt(i)]--;
        }

        // If it's an anagram, all counts will have balanced back to 0
        for (int count : charCounts) {
            if (count != 0) return false;
        }
        return true;
//        int[] sorted1 = s1.chars().sorted().toArray();
//        int[] sorted2 = s2.chars().sorted().toArray();
//        Arrays.equals(sorted1, sorted2);
    }

//    Chracter count Occurrence
    public static int countOccurrence(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }

//    Fibonacci Series
    public static void generate(int n) {

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        int firstTerm = 0;
        int secondTerm = 1;
        System.out.println("Fibonacci Series till " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(firstTerm);
            if (i < n) {
                System.out.print(", ");
            }
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

//    First Non-Repeating Character
    public static Character findFirst(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        // Assuming standard ASCII characters.
        int[] charCounts = new int[256];

        // First pass: Count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i)]++;
        }

        // Second pass: Find the first character with a frequency of exactly 1
        for (int i = 0; i < str.length(); i++) {
            if (charCounts[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return null; // Return null if all characters repeat
    }

//    Longest Common Prefix
//    {"flower", "flow", "flight"},                   // Expected: "fl"

    public static String findPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the prefix...
            while (!strs[i].startsWith(prefix)) {
                // Chop off the last character of the prefix and try again
                prefix = prefix.substring(0, prefix.length() - 1);

                // Early exit: if the prefix shrinks to nothing, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

//    Palindrome Checker racecar
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        if (str.length() <= 1) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

//    Prime Number Checker
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false; // fast check for even numbers

        // Check odd numbers up to the square root of n
//        sqrt bcoz factors repeat after
//        +2 because all even numbers are already removed
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

//    Reverse word in sentence
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Iterate backwards through the array of words
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" "); // Add space separator between words
            }
        }
        return sb.toString();
    }

//    String Compression
//    "aabcccccaaa", // Expected: a2b1c5a3

    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            // If we are at the last character OR the next character is different
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);

                // Reset count for the next sequence of characters
                countConsecutive = 0;
            }
        }
        // Only return the compressed string if it actually saves space
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

//    Add underscore     "javaCodingQuestion", // Standard camelCase
    public static String addUnderscores(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // When we find an uppercase letter...
            if (Character.isUpperCase(c)) {
                // Add an underscore, but ONLY if it's not the very first character
                if (i > 0 && sb.charAt(sb.length() - 1) != '_') {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    White space remover
    public static String remove(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Character.isWhitespace catches spaces, tabs, newlines, etc.
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void run() {

        System.out.println("============== STRING QUESTIONS DEMO ==============");

        // 1. Reverse String
        String reverseInput = "Java";
        System.out.println("\n1. Reverse String");
        System.out.println("Input: " + reverseInput);
        System.out.println("Using Pointers: " + reverseWithPointers(reverseInput));
        System.out.println("Using StringBuilder: " + reverseWithStringBuilder(reverseInput));

        // 2. Find Duplicate Characters
        String duplicateInput = "programming";
        System.out.println("\n2. Find Duplicate Characters");
        System.out.println("Input: " + duplicateInput);
        System.out.println("Duplicates: " + findDuplicates(duplicateInput));

        // 3. Remove Duplicate Characters
        String removeDuplicateInput = "programming";
        System.out.println("\n3. Remove Duplicate Characters");
        System.out.println("Input: " + removeDuplicateInput);
        System.out.println("Output: " + removeDuplicates(removeDuplicateInput));

        // 4. Character Frequency
        String frequencyInput = "banana";
        System.out.println("\n4. Character Frequency");
        System.out.println("Input: " + frequencyInput);
        System.out.println("Output: " + count(frequencyInput));

        // 5. Anagram Check
        String s1 = "silent";
        String s2 = "listen";
        System.out.println("\n5. Anagram Check");
        System.out.println("Input: " + s1 + ", " + s2);
        System.out.println("Output: " + isAnagram(s1, s2));

        // 6. Character Occurrence
        String occurrenceInput = "banana";
        char target = 'a';
        System.out.println("\n6. Character Occurrence");
        System.out.println("Input: " + occurrenceInput);
        System.out.println("Target Character: " + target);
        System.out.println("Count: " + countOccurrence(occurrenceInput, target));

        // 7. Fibonacci Series
        int fibonacciTerms = 10;
        System.out.println("\n7. Fibonacci Series");
        System.out.println("Input: " + fibonacciTerms);
        generate(fibonacciTerms);
        System.out.println();

        // 8. First Non-Repeating Character
        String nonRepeatingInput = "swiss";
        System.out.println("\n8. First Non-Repeating Character");
        System.out.println("Input: " + nonRepeatingInput);
        System.out.println("Output: " + findFirst(nonRepeatingInput));

        // 9. Longest Common Prefix
        String[] prefixInput = {"flower", "flow", "flight"};
        System.out.println("\n9. Longest Common Prefix");
        System.out.println("Input: " + Arrays.toString(prefixInput));
        System.out.println("Output: " + findPrefix(prefixInput));

        // 10. Palindrome Check
        String palindromeInput = "racecar";
        System.out.println("\n10. Palindrome Check");
        System.out.println("Input: " + palindromeInput);
        System.out.println("Output: " + isPalindrome(palindromeInput));

        // 11. Prime Number Check
        int primeInput = 29;
        System.out.println("\n11. Prime Number Check");
        System.out.println("Input: " + primeInput);
        System.out.println("Output: " + isPrime(primeInput));

        // 12. Reverse Words
        String sentence = "Java is awesome";
        System.out.println("\n12. Reverse Words");
        System.out.println("Input: " + sentence);
        System.out.println("Output: " + reverseWords(sentence));

        // 13. String Compression
        String compressionInput = "aabcccccaaa";
        System.out.println("\n13. String Compression");
        System.out.println("Input: " + compressionInput);
        System.out.println("Output: " + compress(compressionInput));

        // 14. Add Underscores
        String camelCaseInput = "javaCodingQuestion";
        System.out.println("\n14. CamelCase to Snake Case");
        System.out.println("Input: " + camelCaseInput);
        System.out.println("Output: " + addUnderscores(camelCaseInput));

        // 15. Remove Whitespaces
        String whitespaceInput = "Java   Coding   Question";
        System.out.println("\n15. Remove Whitespaces");
        System.out.println("Input: " + whitespaceInput);
        System.out.println("Output: " + remove(whitespaceInput));

        System.out.println("\n============== END ==============");
    }

}
