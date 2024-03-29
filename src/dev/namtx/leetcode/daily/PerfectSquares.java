package dev.namtx.leetcode.daily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(99));
    }

    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
