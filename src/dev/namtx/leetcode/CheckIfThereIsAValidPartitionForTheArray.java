package dev.namtx.leetcode;

import java.util.Arrays;

public class CheckIfThereIsAValidPartitionForTheArray {
    int[] dp;
    public static void main(String[] args) {
        System.out.println(new CheckIfThereIsAValidPartitionForTheArray().validPartition(new int[]{1,1,1,2}));
    }

    public boolean validPartition(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return isValidPartition(nums, 0, nums.length);
    }

    private boolean isValidPartition(int[] nums, int start, int end) {
        if (dp[start] != -1) {
            return dp[start] == 1;
        }

        if (end - start <= 1) {
            dp[start] = 0;
            return false;
        }
        if (end - start == 2) {
            if (nums[start] == nums[start + 1]) {
                dp[start] = 1;
                return true;
            } else {
                dp[start] = 1;
                return false;
            }
        }

        if (end - start == 3) {
            if (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2]) {
                dp[start] = 1;
                return true;
            } else if (nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[start + 2]) {
                dp[start] = 1;
                return true;
            } else {
                dp[start] = 0;
                return false;
            }
        }

        boolean ans = (nums[start] == nums[start + 1] && isValidPartition(nums, start + 2, end)) ||
                (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2] && isValidPartition(nums, start + 3, end)) ||
                (nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[start + 2] && isValidPartition(nums, start + 3, end));
        if (ans) {
            dp[start] = 1;
        } else {
            dp[start] = 0;
        }
        return ans;
    }
}
