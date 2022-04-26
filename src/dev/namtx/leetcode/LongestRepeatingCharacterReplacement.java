package dev.namtx.leetcode;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            int right = i;
            int diff = 0;
            while(diff <= k) {
                if (right > s.length() - 1 || s.charAt(right) != s.charAt(i)) {
                    if (right == s.length()) {
                        right++;
                        break;
                    }
                    diff++;
                }
                right++;
            }
            max = Math.max(right- i -1, max);
        }


        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 2));
//        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 1));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABBB", 2));
    }
}

