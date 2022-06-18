package dev.namtx.leetcode;

import java.util.Arrays;

public class OnesAndZeroes {
    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
//        String[] strs = new String[]{"10", "1", "0"};
        System.out.println(new OnesAndZeroes().findMaxForm(strs, 4, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] onesAndZeroes = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int zeroes = (int) strs[i].codePoints().filter(ch -> ch == '0').count();
            onesAndZeroes[i][0] = zeroes;
            onesAndZeroes[i][1] = strs[i].length() - zeroes;
        }
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r, -1);
            }
        }
        return find(onesAndZeroes, 0, m, n, dp);
    }

    int find(int[][] onesAndZeroes, int i, int m, int n, int[][][] dp) {
        if (i == onesAndZeroes.length) return 0;
        if (dp[i][m][n] != -1) return dp[i][m][n];
        dp[i][m][n] = find(onesAndZeroes, i + 1, m, n, dp);
        int zeroes = onesAndZeroes[i][0];
        int ones = onesAndZeroes[i][1];
        if (m - zeroes >= 0 && n - ones >= 0) {
            dp[i][m][n] = Math.max(dp[i][m][n], 1 + find(onesAndZeroes, i + 1, m - zeroes, n - ones, dp));
        }

        return dp[i][m][n];
    }
}
