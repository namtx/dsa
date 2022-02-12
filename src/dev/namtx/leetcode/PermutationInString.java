package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string
 *
 * tags: string, two pointers, sliding window, hash table
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("dca", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] h1 = new int[26];
        int[] h2 = new int[26];

        if (s1.length() > s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            h1[s1.charAt(i) - 'a']++;
            h2[s2.charAt(i) - 'a']++;
        }

        int windowSize = s1.length();
        for (int left = 0; left < s2.length() - windowSize; left++) {
            if (matches(h1, h2)) return true;

            h2[s2.charAt(left) - 'a']--;
            h2[s2.charAt(left + windowSize) - 'a']++;
        }

        return matches(h1, h2);
    }

    private boolean matches(int[] h1, int[] h2) {
        for (int i = 0; i < 26; i++) {
            if (h1[i] != h2[i]) {
                return false;
            }
        }

        return true;
    }
}

