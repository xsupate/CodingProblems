package pg.com.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNDistinct {

    public static String longestSubstringNDistinct(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return "";
        }

        int start = 0; // Start index of the current substring
        int maxLength = 0; // Maximum length of substring with n distinct characters
        int uniqueCount = 0; // Count of unique characters in the current substring
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);

            // Update character count map
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            // If a new distinct character is encountered
            if (charCountMap.get(currentChar) == 1) {
                uniqueCount++;
            }

            // Adjust the window by removing characters from the start
            while (uniqueCount > n) {
                char startChar = str.charAt(start);
                charCountMap.put(startChar, charCountMap.get(startChar) - 1);

                // If the count becomes 0, decrement the uniqueCount
                if (charCountMap.get(startChar) == 0) {
                    uniqueCount--;
                }

                start++;
            }

            // Update maxLength if the current substring is longer
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
            }
        }

        // Extract the longest substring
        return str.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String inputString = "abcabcbb";
        int n = 2;

        String longestSubstring = longestSubstringNDistinct(inputString, n);

        System.out.println("Longest substring with " + n + " distinct characters: " + longestSubstring);
    }
}

