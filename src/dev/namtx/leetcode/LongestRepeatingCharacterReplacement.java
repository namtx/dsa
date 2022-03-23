package dev.namtx.leetcode;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int left = i;
            int right = i;
            int diff = 0;
            while(diff <= k) {
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    left--;
                }
                diff++;
                while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                    right++;
                }
                diff++;
            }
            while(left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            while(right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            max = Math.max(right-left, max);
        }


        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }
}

