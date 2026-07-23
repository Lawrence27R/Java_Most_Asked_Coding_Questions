package com.codes.java;

import java.util.*;

// ============================================================================
// STRING CODING QUESTIONS
// Questions 1 - 30
// ============================================================================

public class StringCodingQuestionsCode {

    // ============================================================================
    // Question: Reverse String  (Using Two Pointer)
    // Input : "Lawrence"
    // Output: "ecnerwaL"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String reverseString(String str) {

        if (str == null || str.isEmpty()) return str;

        char[] arr  = str.toCharArray();
        int    left  = 0;
        int    right = arr.length - 1;

        while (left < right) {
            char temp  = arr[left];
            arr[left]  = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    // ============================================================================
    // Question: Reverse String Using StringBuilder
    // Input : "Lawrence"
    // Output: "ecnerwaL"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String reverseStringBuilder(String str) {

        if (str == null) return null;

        return new StringBuilder(str).reverse().toString();
    }

    // ============================================================================
    // Question: Palindrome Check
    // Input : "racecar"
    // Output: true
    // (A palindrome reads the same forwards and backwards)
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static boolean isPalindrome(String str) {

        if (str == null)
            return false;

        int left  = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // ============================================================================
    // Question: Anagram Check
    // Input : "silent", "listen"
    // Output: true
    // (Two strings are anagrams if they have the same characters, same frequency)
    // Time Complexity : O(n log n)
    // Space Complexity: O(n)
    // ============================================================================
    public static boolean isAnagram(String s1, String s2) {

        if (s1 == null || s2 == null){
            return false;
        }
        if (s1.length() != s2.length()){
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // ============================================================================
    // Question: Character Frequency Count
    // Input : "banana"
    // Output: {b=1, a=3, n=2}
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Map<Character, Integer> countCharacterFrequency(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        if (str == null) return map;

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

    // ============================================================================
    // Question: Count Occurrence Of A Character
    // Input : "banana", 'a'
    // Output: 3
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int countOccurrence(String str, char target) {

        if (str == null) return 0;

        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == target){
                count++;
            }
        }

        return count;
    }

    // ============================================================================
    // Question: Find Duplicate Characters
    // Input : "programming"
    // Output: [r, g, m]
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Set<Character> findDuplicates(String str) {

        Set<Character> set       = new HashSet<>();
        Set<Character> duplicates = new LinkedHashSet<>();

        if (str == null){
            return duplicates;
        }

        for (char ch : str.toCharArray()) {
            if (!set.add(ch)) {
                duplicates.add(ch);
            }
        }

        return duplicates;
    }

    // ============================================================================
    // Question: Remove Duplicate Characters
    // Input : "programming"
    // Output: "progamin"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String removeDuplicates(String str) {

        if (str == null || str.isEmpty()){
            return str;
        }

        Set<Character>  set = new LinkedHashSet<>();
        StringBuilder    sb  = new StringBuilder();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        for (char ch : set) {
            sb.append(ch);
        }

        return sb.toString();
    }

    // ============================================================================
    // Question: First Non-Repeating Character
    // Input : "swiss"
    // Output: 'w'
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character firstNonRepeatingCharacter(String str) {

        if (str == null || str.isEmpty()){
            return null;
        }

        Map<Character, Integer> map = countCharacterFrequency(str);

        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1)
                return ch;
        }

        return null;
    }

    // ============================================================================
    // Question: First Repeating Character
    // Input : "swiss"
    // Output: 's'
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character firstRepeatingCharacter(String str) {

        if (str == null || str.isEmpty()){
            return null;
        }

        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!set.add(ch))
                return ch;
        }

        return null;
    }

    // ============================================================================
    // Question: Maximum Occurring Character
    // Input : "banana"
    // Output: 'a'  (appears 3 times)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character maxOccurringCharacter(String str) {

        if (str == null || str.isEmpty()){
            return null;
        }

        Map<Character, Integer> map = countCharacterFrequency(str);

        Character result = null;
        int max = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max    = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Minimum Occurring Character
    // Input : "banana"
    // Output: 'b'  (appears 1 time)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character minOccurringCharacter(String str) {

        if (str == null || str.isEmpty()){
            return null;
        }

        Map<Character, Integer> map = countCharacterFrequency(str);

        Character result = null;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min    = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Reverse Words In A Sentence
    // Input : "Java is awesome"
    // Output: "awesome is Java"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String reverseWords(String sentence) {

        String[] words = sentence.split(" ");

        List<String> list = Arrays.asList(words);

        Collections.reverse(list);

        return String.join(" ", list);
    }

    // ============================================================================
    // Question: Reverse Each Word In A Sentence
    // Input : "Java Coding"
    // Output: "avaJ gnidoC"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        List<String> list = Arrays.asList(words);

        StringBuilder result = new StringBuilder();

        for (String word : list) {
            result.append(reverseString(word))
                    .append(" ");
        }

        return result.toString().trim();
    }

    // ============================================================================
    // Question: Find the Longest Common Prefix
    // Input : ["flower", "flow", "flight"]
    // Output: "fl"
    // ============================================================================
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = "";

        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

//                if rest other words length is less than first for prefix or char is not equal to first word prefix
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return prefix;
                }
            }

            prefix += ch;
        }

        return prefix;
    }

    // ============================================================================
    // Question: String Compression
    // Input : "aabcccccaaa"
    // Output: "a2b1c5a3"
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static String compressString(String str) {

        if (str == null || str.isEmpty()){
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {

            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }

        return compressed.toString();
    }

    // ============================================================================
    // Question: Rotation String Check
    // Input : "ABCD", "CDAB"
    // Output: true
    // (s2 is a rotation of s1 if s2 exists in s1+s1)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static boolean isRotation(String s1, String s2) {

        if (s1 == null || s2 == null){
            return false;
        }

        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    // ============================================================================
    // Question: Check String Contains Only Digits
    // Input : "12345"
    // Output: true
    // Time Complexity : O(n)
    // ============================================================================
    public static boolean containsOnlyDigits(String str) {

        if (str == null || str.isEmpty()){
            return false;
        }

        return str.matches("\\d+");
    }

    // ============================================================================
    // Question: Remove Whitespaces
    // Input : "Java Coding Question"
    // Output: "JavaCodingQuestion"
    // Time Complexity : O(n)
    // ============================================================================
    public static String removeWhitespaces(String str) {

        if (str == null) return null;

        return str.replace(" ", "");
    }

    // ============================================================================
    // Question: Remove Special Characters
    // Input : "Java@123#Code!"
    // Output: "Java123Code"
    // Time Complexity : O(n)
    // ============================================================================
    public static String removeSpecialCharacters(String str) {

        if (str == null) return null;

        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // ============================================================================
    // Question: Count Vowels And Consonants
    // Input : "Lawrence"
    // Output: Vowels = 3, Consonants = 5
    // Time Complexity : O(n)
    // ============================================================================
    public static void countVowelsAndConsonants(String str) {

        int vowels     = 0;
        int consonants = 0;

        if (str == null) {
            System.out.println("    Vowels     : " + vowels);
            System.out.println("    Consonants : " + consonants);
            return;
        }

        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("    Vowels     : " + vowels);
        System.out.println("    Consonants : " + consonants);
    }

    // ============================================================================
    // Question: CamelCase To SnakeCase
    // Input : "javaCodingQuestion"
    // Output: "java_coding_question"
    // Time Complexity : O(n)
    // ============================================================================
    public static String camelCaseToSnakeCase(String str) {

        if (str == null || str.isEmpty()) return str;

        return str.replace(" ", "_");
    }

    // ============================================================================
    // Question: SnakeCase To CamelCase
    // Input : "java_coding_question"
    // Output: "javaCodingQuestion"
    // Time Complexity : O(n)
    // ============================================================================
    public static String snakeCaseToCamelCase(String str) {

        if (str == null || str.isEmpty()) return str;

        StringBuilder result       = new StringBuilder();
        boolean       upperNext    = false;

        for (char ch : str.toCharArray()) {
            if (ch == '_') {
                upperNext = true;
            } else {
                if (upperNext) {
                    result.append(Character.toUpperCase(ch));
                    upperNext = false;
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    // ============================================================================
    // Question: Check Two Strings Equal Without equals()
    // Input : "Java", "Java"
    // Output: true
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static boolean areStringsEqual(String s1, String s2) {

        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }

        return true;
    }

    // ============================================================================
    // Question: Count Number Of Words In A Sentence
    // Input : "Java Coding Interview"
    // Output: 3
    // Time Complexity : O(n)
    // ============================================================================
    public static int countWords(String sentence) {

        if (sentence == null || sentence.trim().isEmpty()) return 0;

        return sentence.trim().split("\\s+").length;
    }

    // ============================================================================
    // Question: Longest Palindromic Substring
    // Input : "babad"
    // Output: "bab"
    // Time Complexity : O(n^2)
    // Space Complexity: O(n)
    // ============================================================================
    public static String longestPalindromicSubstring(String str) {

        if (str == null || str.length() < 2) return str;

        String longest = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

                String sub = str.substring(i, j);

                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }

    // ============================================================================
    // Question: Generate All Substrings
    // Input : "ABC"
    // Output: [A, AB, ABC, B, BC, C]
    // Time Complexity : O(n^2)
    // Space Complexity: O(n^2)
    // ============================================================================
    public static List<String> generateAllSubstrings(String str) {

        List<String> result = new ArrayList<>();

        if (str == null) return result;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                result.add(str.substring(i, j));
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Longest Substring Without Repeating Characters
    // Input : "abcabcbb"
    // Output: "abc"
    // Explanation: "abc" is the longest substring without repeating characters.
    // ============================================================================
    public static String longestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxLength);
    }

    // ============================================================================
    // Question: Balanced Parentheses Check
    // Input : "({[]})"
    // Output: true
    // (Every opening bracket must have a matching closing bracket in correct order)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
//    LIFO Last In First Out
    // ============================================================================
    public static boolean isBalancedParentheses(String str) {

        if (str == null)
            return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {

//                str = ")"; for this test case
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(')
                        || (ch == '}' && top != '{')
                        || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // ============================================================================
    // Question: String Permutations
    // Input : "ABC"
    // Output: ABC, ACB, BAC, BCA, CAB, CBA
    // Time Complexity : O(n!)
    // ============================================================================
    public static void printPermutations(String str, String permutation) {

        if (str == null) return;

        if (str.length() == 0) {
            System.out.println("    " + permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char   current   = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);

            printPermutations(remaining, permutation + current);
        }
    }

    // ============================================================================
    //                          RUN ALL METHODS
    // ============================================================================
    public static void run() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("           STRING CODING QUESTIONS - ALL METHODS            ");
        System.out.println("============================================================");

        // ------------------------------------------------------------------
        System.out.println("\n1.  Reverse String (Two Pointer)");
        System.out.println("    Input  : \"Lawrence\"");
        System.out.println("    Output : " + reverseString("Lawrence"));

        // ------------------------------------------------------------------
        System.out.println("\n2.  Reverse String (StringBuilder)");
        System.out.println("    Input  : \"Lawrence\"");
        System.out.println("    Output : " + reverseStringBuilder("Lawrence"));

        // ------------------------------------------------------------------
        System.out.println("\n3.  Palindrome Check");
        System.out.println("    Input  : \"racecar\"");
        System.out.println("    Output : " + isPalindrome("racecar"));

        // ------------------------------------------------------------------
        System.out.println("\n4.  Anagram Check");
        System.out.println("    Input  : \"silent\", \"listen\"");
        System.out.println("    Output : " + isAnagram("silent", "listen"));

        // ------------------------------------------------------------------
        System.out.println("\n5.  Character Frequency Count");
        System.out.println("    Input  : \"banana\"");
        System.out.println("    Output : " + countCharacterFrequency("banana"));

        // ------------------------------------------------------------------
        System.out.println("\n6.  Count Occurrence Of Character");
        System.out.println("    Input  : \"banana\", 'a'");
        System.out.println("    Output : " + countOccurrence("banana", 'a'));

        // ------------------------------------------------------------------
        System.out.println("\n7.  Find Duplicate Characters");
        System.out.println("    Input  : \"programming\"");
        System.out.println("    Output : " + findDuplicates("programming"));

        // ------------------------------------------------------------------
        System.out.println("\n8.  Remove Duplicate Characters");
        System.out.println("    Input  : \"programming\"");
        System.out.println("    Output : " + removeDuplicates("programming"));

        // ------------------------------------------------------------------
        System.out.println("\n9.  First Non-Repeating Character");
        System.out.println("    Input  : \"swiss\"");
        System.out.println("    Output : " + firstNonRepeatingCharacter("swiss"));

        // ------------------------------------------------------------------
        System.out.println("\n10. First Repeating Character");
        System.out.println("    Input  : \"swiss\"");
        System.out.println("    Output : " + firstRepeatingCharacter("swiss"));

        // ------------------------------------------------------------------
        System.out.println("\n11. Maximum Occurring Character");
        System.out.println("    Input  : \"banana\"");
        System.out.println("    Output : " + maxOccurringCharacter("banana"));

        // ------------------------------------------------------------------
        System.out.println("\n12. Minimum Occurring Character");
        System.out.println("    Input  : \"banana\"");
        System.out.println("    Output : " + minOccurringCharacter("banana"));

        // ------------------------------------------------------------------
        System.out.println("\n13. Reverse Words In Sentence");
        System.out.println("    Input  : \"Java is awesome\"");
        System.out.println("    Output : " + reverseWords("Java is awesome"));

        // ------------------------------------------------------------------
        System.out.println("\n14. Reverse Each Word In Sentence");
        System.out.println("    Input  : \"Java Coding\"");
        System.out.println("    Output : " + reverseEachWord("Java Coding"));

        // ------------------------------------------------------------------
        System.out.println("\n15. Longest Common Prefix");
        System.out.println("    Input  : [\"flower\", \"flow\", \"flight\"]");
        System.out.println("    Output : " + longestCommonPrefix(
                new String[]{"flower", "flow", "flight"}));

        // ------------------------------------------------------------------
        System.out.println("\n16. String Compression");
        System.out.println("    Input  : \"aabcccccaaa\"");
        System.out.println("    Output : " + compressString("aabcccccaaa"));

        // ------------------------------------------------------------------
        System.out.println("\n17. Rotation String Check");
        System.out.println("    Input  : \"ABCD\", \"CDAB\"");
        System.out.println("    Output : " + isRotation("ABCD", "CDAB"));

        // ------------------------------------------------------------------
        System.out.println("\n18. Contains Only Digits");
        System.out.println("    Input  : \"12345\"");
        System.out.println("    Output : " + containsOnlyDigits("12345"));

        // ------------------------------------------------------------------
        System.out.println("\n19. Remove Whitespaces");
        System.out.println("    Input  : \"Java Coding Question\"");
        System.out.println("    Output : " + removeWhitespaces("Java Coding Question"));

        // ------------------------------------------------------------------
        System.out.println("\n20. Remove Special Characters");
        System.out.println("    Input  : \"Java@123#Code!\"");
        System.out.println("    Output : " + removeSpecialCharacters("Java@123#Code!"));

        // ------------------------------------------------------------------
        System.out.println("\n21. Count Vowels And Consonants");
        System.out.println("    Input  : \"Lawrence\"");
        countVowelsAndConsonants("Lawrence");

        // ------------------------------------------------------------------
        System.out.println("\n22. CamelCase To SnakeCase");
        System.out.println("    Input  : \"javaCodingQuestion\"");
        System.out.println("    Output : " + camelCaseToSnakeCase("javaCodingQuestion"));

        // ------------------------------------------------------------------
        System.out.println("\n23. SnakeCase To CamelCase");
        System.out.println("    Input  : \"java_coding_question\"");
        System.out.println("    Output : " + snakeCaseToCamelCase("java_coding_question"));

        // ------------------------------------------------------------------
        System.out.println("\n24. Check Two Strings Equal (Without equals())");
        System.out.println("    Input  : \"Java\", \"Java\"");
        System.out.println("    Output : " + areStringsEqual("Java", "Java"));

        // ------------------------------------------------------------------
        System.out.println("\n25. Count Number Of Words");
        System.out.println("    Input  : \"Java Coding Interview\"");
        System.out.println("    Output : " + countWords("Java Coding Interview"));

        // ------------------------------------------------------------------
        System.out.println("\n26. Longest Palindromic Substring");
        System.out.println("    Input  : \"babad\"");
        System.out.println("    Output : " + longestPalindromicSubstring("babad"));

        // ------------------------------------------------------------------
        System.out.println("\n27. Generate All Substrings");
        System.out.println("    Input  : \"ABC\"");
        System.out.println("    Output : " + generateAllSubstrings("ABC"));

        // ------------------------------------------------------------------
        System.out.println("\n28. Longest Substring Without Repeating Characters");
        System.out.println("    Input  : \"abcabcbb\"");
//        System.out.println("    Output : " + longestSubstringWithoutRepeating("abcabcbb"));
        System.out.println("    (Longest unique window = \"abc\" = length 3)");

        // ------------------------------------------------------------------
        System.out.println("\n29. Balanced Parentheses Check");
        System.out.println("    Input  : \"({[]})\"");
        System.out.println("    Output : " + isBalancedParentheses("({[]})"));

        // ------------------------------------------------------------------
        System.out.println("\n30. String Permutations");
        System.out.println("    Input  : \"ABC\"");
        System.out.println("    Output :");
        printPermutations("ABC", "");

        System.out.println("\n============================================================");
        System.out.println("                  ALL METHODS EXECUTED !                    ");
        System.out.println("============================================================");
        System.out.println();
    }

}