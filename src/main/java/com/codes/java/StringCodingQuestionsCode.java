package com.codes.java;

import java.util.*;

// ============================================================================
// STRING CODING QUESTIONS - PART 1
// Questions 1 - 10
// ============================================================================

public class StringCodingQuestionsCode {

    // ============================================================================
    // Question: Reverse String
    // Input : "Lawrence"
    // Output: "ecnerwaL"
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static String reverseString(String str) {

        if (str == null || str.isEmpty())
            return str;

        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
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

        if (str == null)
            return null;

        return new StringBuilder(str).reverse().toString();
    }

    // ============================================================================
    // Question: Palindrome Check
    // Input : "racecar"
    // Output: true
    // ============================================================================
    public static boolean isPalindrome(String str) {

        if (str == null)
            return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    // ============================================================================
    // Question: Anagram Check
    // Input : "silent", "listen"
    // Output: true
    // ============================================================================
    public static boolean isAnagram(String s1, String s2) {

        if (s1 == null || s2 == null)
            return false;

        if (s1.length() != s2.length())
            return false;

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
    // ============================================================================
    public static Map<Character, Integer> countCharacterFrequency(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        if (str == null)
            return map;

        for (char ch : str.toCharArray()) {

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

    // ============================================================================
    // Question: Count Occurrence Of Character
    // Input : "banana", 'a'
    // Output: 3
    // ============================================================================
    public static int countOccurrence(String str, char target) {

        if (str == null)
            return 0;

        int count = 0;

        for (char ch : str.toCharArray()) {

            if (ch == target)
                count++;
        }

        return count;
    }

    // ============================================================================
    // Question: Find Duplicate Characters
    // Input : "programming"
    // Output: [r, g, m]
    // ============================================================================
    public static Set<Character> findDuplicates(String str) {

        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new LinkedHashSet<>();

        if (str == null)
            return duplicates;

        for (char ch : str.toCharArray()) {

            if (!seen.add(ch)) {

                duplicates.add(ch);
            }
        }

        return duplicates;
    }

    // ============================================================================
    // Question: Remove Duplicate Characters
    // Input : "programming"
    // Output: "progamin"
    // ============================================================================
    public static String removeDuplicates(String str) {

        if (str == null || str.isEmpty())
            return str;

        Set<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {

            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : set) {

            sb.append(ch);
        }

        return sb.toString();
    }

    // ============================================================================
    // Question: First Non-Repeating Character
    // Input : "swiss"
    // Output: 'w'
    // ============================================================================
    public static Character firstNonRepeatingCharacter(String str) {

        if (str == null || str.isEmpty())
            return null;

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
    // ============================================================================
    public static Character firstRepeatingCharacter(String str) {

        if (str == null || str.isEmpty())
            return null;

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
    // Output: 'a'
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character maxOccurringCharacter(String str) {

        if (str == null || str.isEmpty())
            return null;

        Map<Character, Integer> map = countCharacterFrequency(str);

        Character result = null;
        int max = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() > max) {

                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Minimum Occurring Character
    // Input : "banana"
    // Output: 'b'
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Character minOccurringCharacter(String str) {

        if (str == null || str.isEmpty())
            return null;

        Map<Character, Integer> map = countCharacterFrequency(str);

        Character result = null;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() < min) {

                min = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Reverse Words In Sentence
    // Input : "Java is awesome"
    // Output: "awesome is Java"
    // Time Complexity : O(n)
    // ============================================================================
    public static String reverseWords(String sentence) {

        if (sentence == null || sentence.trim().isEmpty())
            return sentence;

        String[] words = sentence.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            sb.append(words[i]);

            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    // ============================================================================
    // Question: Reverse Each Word In Sentence
    // Input : "Java Coding"
    // Output: "avaJ gnidoC"
    // ============================================================================
    public static String reverseEachWord(String sentence) {

        if (sentence == null || sentence.isEmpty())
            return sentence;

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            result.append(reverseString(word)).append(" ");
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    // ============================================================================
    // Question: Longest Common Prefix
    // Input : {"flower","flow","flight"}
    // Output: "fl"
    // ============================================================================
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0 || strs[0] == null)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            if (strs[i] == null)
                return "";

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    // ============================================================================
    // Question: String Compression
    // Input : "aabcccccaaa"
    // Output: "a2b1c5a3"
    // ============================================================================
    public static String compressString(String str) {

        if (str == null || str.isEmpty())
            return str;

        StringBuilder compressed = new StringBuilder();

        int count = 1;

        for (int i = 0; i < str.length(); i++) {

            if (i + 1 < str.length()
                    && str.charAt(i) == str.charAt(i + 1)) {

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
    // Question: Rotational String Check
    // Input : "ABCD", "CDAB"
    // Output: true
    // ============================================================================
    public static boolean isRotation(String s1, String s2) {

        if (s1 == null || s2 == null)
            return false;

        return s1.length() == s2.length()
                && (s1 + s1).contains(s2);
    }

    // ============================================================================
    // Question: Check String Contains Only Digits
    // Input : "12345"
    // Output: true
    // ============================================================================
    public static boolean containsOnlyDigits(String str) {

        if (str == null || str.isEmpty())
            return false;

        return str.matches("\\d+");
    }

    // ============================================================================
    // Question: Remove Whitespaces
    // Input : "Java Coding Question"
    // Output: "JavaCodingQuestion"
    // ============================================================================
    public static String removeWhitespaces(String str) {

        if (str == null)
            return null;

        return str.replaceAll("\\s+", "");
    }

    // ============================================================================
    // Question: Remove Special Characters
    // Input : "Java@123#Code!"
    // Output: "Java123Code"
    // ============================================================================
    public static String removeSpecialCharacters(String str) {

        if (str == null)
            return null;

        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // ============================================================================
    // Question: Count Vowels And Consonants
    // Input : "Lawrence"
    // Output: Vowels = 3, Consonants = 5
    // ============================================================================
    public static void countVowelsAndConsonants(String str) {

        int vowels = 0;
        int consonants = 0;

        if (str == null) {
            System.out.println("Vowels     : " + vowels);
            System.out.println("Consonants : " + consonants);
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

        System.out.println("Vowels     : " + vowels);
        System.out.println("Consonants : " + consonants);
    }

    // ============================================================================
    // Question: CamelCase To SnakeCase
    // Input : javaCodingQuestion
    // Output: java_coding_question
    // ============================================================================
    public static String camelCaseToSnakeCase(String str) {

        if (str == null || str.isEmpty())
            return str;

        return str.replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }

    // ============================================================================
    // Question: SnakeCase To CamelCase
    // Input : java_coding_question
    // Output: javaCodingQuestion
    // ============================================================================
    public static String snakeCaseToCamelCase(String str) {

        if (str == null || str.isEmpty())
            return str;

        StringBuilder result = new StringBuilder();

        boolean upperCaseNext = false;

        for (char ch : str.toCharArray()) {

            if (ch == '_') {

                upperCaseNext = true;

            } else {

                if (upperCaseNext) {

                    result.append(Character.toUpperCase(ch));
                    upperCaseNext = false;

                } else {

                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    // ============================================================================
    // Question: Check Two Strings Equal Without equals()
    // Input : Java , Java
    // Output: true
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
    // Question: Count Number Of Words
    // Input : Java Coding Interview
    // Output: 3
    // ============================================================================
    public static int countWords(String sentence) {

        if (sentence == null || sentence.trim().isEmpty())
            return 0;

        return sentence.trim().split("\\s+").length;
    }

    // ============================================================================
    // Question: Longest Palindromic Substring
    // Input : babad
    // Output: bab
    // ============================================================================
    public static String longestPalindromicSubstring(String str) {

        if (str == null || str.length() < 2)
            return str;

        String longest = "";

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {

                String sub = str.substring(i, j);

                if (isPalindrome(sub)
                        && sub.length() > longest.length()) {

                    longest = sub;
                }
            }
        }

        return longest;
    }

    // ============================================================================
    // Question: Generate All Substrings
    // Input : ABC
    // Output : A AB ABC B BC C
    // ============================================================================
    public static List<String> generateAllSubstrings(String str) {

        List<String> result = new ArrayList<>();

        if (str == null)
            return result;

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {

                result.add(str.substring(i, j));
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Longest Substring Without Repeating Characters
    // Input : abcabcbb
    // Output: 3
    // ============================================================================
    public static int longestSubstringWithoutRepeating(String str) {

        if (str == null)
            return 0;

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {

            while (set.contains(str.charAt(right))) {

                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));

            maxLength = Math.max(maxLength,
                    right - left + 1);
        }

        return maxLength;
    }

    // ============================================================================
    // Question: Balanced Parentheses
    // Input : ({[]})
    // Output: true
    // ============================================================================
    public static boolean isBalancedParentheses(String str) {

        if (str == null)
            return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {

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
    // Input : ABC
    // ============================================================================
    public static void printPermutations(String str,
                                         String permutation) {

        if (str == null)
            return;

        if (str.length() == 0) {

            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            String remaining =
                    str.substring(0, i)
                            + str.substring(i + 1);

            printPermutations(
                    remaining,
                    permutation + current
            );
        }
    }

    public static void run() {

        System.out.println("=============== STRING CODING QUESTIONS ===============");

        System.out.println("1. Reverse String : "
                + reverseString("Lawrence"));

        System.out.println("2. Reverse StringBuilder : "
                + reverseStringBuilder("Lawrence"));

        System.out.println("3. Palindrome : "
                + isPalindrome("racecar"));

        System.out.println("4. Anagram : "
                + isAnagram("silent", "listen"));

        System.out.println("5. Character Frequency : "
                + countCharacterFrequency("banana"));

        System.out.println("6. Count Occurrence : "
                + countOccurrence("banana", 'a'));

        System.out.println("7. Duplicate Characters : "
                + findDuplicates("programming"));

        System.out.println("8. Remove Duplicates : "
                + removeDuplicates("programming"));

        System.out.println("9. First Non-Repeating : "
                + firstNonRepeatingCharacter("swiss"));

        System.out.println("10. First Repeating : "
                + firstRepeatingCharacter("swiss"));

        System.out.println("11. Max Occurring : "
                + maxOccurringCharacter("banana"));

        System.out.println("12. Min Occurring : "
                + minOccurringCharacter("banana"));

        System.out.println("13. Reverse Words : "
                + reverseWords("Java is awesome"));

        System.out.println("14. Reverse Each Word : "
                + reverseEachWord("Java Coding"));

        System.out.println("15. Longest Prefix : "
                + longestCommonPrefix(
                new String[]{"flower", "flow", "flight"}));

        System.out.println("16. Compression : "
                + compressString("aabcccccaaa"));

        System.out.println("17. Rotation : "
                + isRotation("ABCD", "CDAB"));

        System.out.println("18. Digits Only : "
                + containsOnlyDigits("12345"));

        System.out.println("19. Remove Spaces : "
                + removeWhitespaces("Java Coding Question"));

        System.out.println("20. Remove Special : "
                + removeSpecialCharacters("Java@123#Code!"));

        System.out.println("21. Vowels & Consonants");
        countVowelsAndConsonants("Lawrence");

        System.out.println("22. Camel To Snake : "
                + camelCaseToSnakeCase("javaCodingQuestion"));

        System.out.println("23. Snake To Camel : "
                + snakeCaseToCamelCase("java_coding_question"));

        System.out.println("24. String Equal : "
                + areStringsEqual("Java", "Java"));

        System.out.println("25. Count Words : "
                + countWords("Java Coding Interview"));

        System.out.println("26. Longest Palindrome : "
                + longestPalindromicSubstring("babad"));

        System.out.println("27. All Substrings : "
                + generateAllSubstrings("ABC"));

        System.out.println("28. Longest Unique Substring : "
                + longestSubstringWithoutRepeating("abcabcbb"));

        System.out.println("29. Balanced Parentheses : "
                + isBalancedParentheses("({[]})"));

        System.out.println("30. Permutations of ABC");
        printPermutations("ABC", "");
    }
}