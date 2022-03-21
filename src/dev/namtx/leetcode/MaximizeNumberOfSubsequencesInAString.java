package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string
 */
public class MaximizeNumberOfSubsequencesInAString {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] patternChars = pattern.toCharArray();
        long countFirstCharacter = 0;
        long countSecondCharacter = 0;
        long ans = 0;
        for (char c : text.toCharArray()) {
            if (c == patternChars[0]) {
                countFirstCharacter++;
            } else if (c == patternChars[1]) {
                ans += countFirstCharacter;
                countSecondCharacter++;
            }
        }
        if (patternChars[0] == patternChars[1]) {
            return (long) (((double) countFirstCharacter) * ((double) countFirstCharacter + 1) / 2);
        }
        if (countFirstCharacter == 0 || countSecondCharacter == 0) {
            return Math.max(countFirstCharacter, countSecondCharacter);
        }
        return (long) ((double) ans + (double) Math.max(countFirstCharacter, countSecondCharacter));
    }
}
