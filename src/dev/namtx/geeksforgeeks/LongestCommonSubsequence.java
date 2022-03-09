package dev.namtx.geeksforgeeks;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(s1, s2));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequenceDPWithTabulation(s1, s2));
    }

    public int longestCommonSubsequence(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + longestCommonSubsequence(s1.substring(1), s2.substring(1));
        } else {
            return Math.max(longestCommonSubsequence(s1.substring(1), s2), longestCommonSubsequence(s1, s2.substring(1)));
        }
    }

    public int longestCommonSubsequenceDPWithTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
