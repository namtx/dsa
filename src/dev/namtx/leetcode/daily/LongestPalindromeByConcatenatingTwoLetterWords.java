package dev.namtx.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] words = new String[]{"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(words));
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> h = new HashMap<>();
        int ans = 0;
        boolean hasCentral = false;
        for (String word : words) {
            int count = h.getOrDefault(word, 0) + 1;
            h.put(word, count);
        }
        for (Map.Entry<String, Integer> e : h.entrySet()) {
            String str = e.getKey();
            int count = e.getValue();
            if (str.charAt(0) == str.charAt(1)) {
                if (count % 2 == 0) {
                    ans += count;
                } else {
                    ans += count - 1;
                    hasCentral = true;
                }
            } else if (str.charAt(0) < str.charAt(1)) {
                String reversed = "" + str.charAt(1) + str.charAt(0);
                if (h.containsKey(reversed)) {
                    ans += 2 * Math.min(count, h.get(reversed));
                }
            }
        }
        if (hasCentral) {
            ans++;
        }

        return ans * 2;
    }
}