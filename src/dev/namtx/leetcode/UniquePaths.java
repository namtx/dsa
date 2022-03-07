package dev.namtx.leetcode;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(1, 1));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;

        // last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = 1;
        }
        // last row
        for (int j = 0; j < n - 1; j++) {
            dp[m - 1][j] = 1;
        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 2; i >= 0; i--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}
