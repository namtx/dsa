package dev.namtx.leetcode;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        System.out.println(new FindTheHighestAltitude().largestAltitude(new int[]{52, -91, 72}));
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int[] dp = new int[gain.length];
        for (int i = 0; i < gain.length; i++) {
            if (i == 0) {
                dp[i] = gain[i];
            } else {
                dp[i] = dp[i - 1] + gain[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
