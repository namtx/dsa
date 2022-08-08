package dev.namtx.leetcode;

public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans = 1;

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            dp[ch] = dp[ch] + 1;

            for (int j = Math.max(0, ch - k); j <= Math.min(25, ch + k); j++) {
                if (j != ch) {
                    dp[ch] = Math.max(dp[ch], dp[j] + 1);
                }
            }

            ans = Math.max(dp[ch], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIdealSubsequence().longestIdealString("acfgbd", 2));
    }
}
