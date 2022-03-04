package dev.namtx.leetcode;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[101];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = 0;
                } else if (j == i) {
                    dp[j] = dp[j - 1] * 0.5;
                } else {
                    dp[j] = Math.max(0, dp[j - 1] - 1) * 0.5 + Math.max(0, dp[j] - 1) * 0.5;
                }
            }
        }
        return Math.min(1, dp[query_glass]);
    }
}
