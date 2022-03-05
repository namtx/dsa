package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1001, 2, 3, 4}));
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> h = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            h.put(n, h.getOrDefault(n, 0) + n);
            max = Math.max(n, max);
        }
        int[] dp = new int[max + 1];
        dp[1] = h.getOrDefault(1, 0);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + h.getOrDefault(i, 0), dp[i - 1]);
        }

        return dp[max];
    }
}
