package dev.namtx.leetcode;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("racecar"));
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                int mid = j + i / 2;
                if (s.charAt(j) == s.charAt(i + j)) {
                    dp[j][j + i] = 2 + dp[j + 1][i + j - 1];
                } else {
                    dp[j][j + i] = Math.max(dp[j][mid], dp[mid + 1][j + i]);
                }
                max = Math.max(max, dp[j][j + i]);
            }
        }

        return max;
    }
}
