package dev.namtx.leetcode.contest;

public class MinimumCostToMakeArrayEqual {
    public static void main(String[] args) {

    }

    public long minCost(int[] nums, int[] cost) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long c = 0;
            for (int j = 0; j < nums.length; j++) {
                c += (long) Math.abs(nums[j] - nums[i]) * cost[j];
            }

            min = Math.min(min, c);
        }

        return min;
    }
}
