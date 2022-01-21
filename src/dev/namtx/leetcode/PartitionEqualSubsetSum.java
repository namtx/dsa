package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public static final int UNCALCULATED = -1;
    public static final int IMPOSSIBLE = 1;
    public static final int POSSIBLE = 0;

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) Arrays.fill(dp[i], UNCALCULATED);

        return subsetSum(nums, dp, sum / 2, 0);
    }

    private boolean subsetSum(int[] nums, int[][] dp, int sum, int i) {
        if (sum == 0) return true;

        if (i == nums.length || sum < 0) return false;

        if (dp[i][sum] != UNCALCULATED) return dp[i][sum] == POSSIBLE;

        dp[i][sum] = (subsetSum(nums, dp, sum - nums[i], i + 1) || subsetSum(nums, dp, sum, i + 1)) ? POSSIBLE : IMPOSSIBLE;

        return dp[i][sum] == POSSIBLE;
    }
}
