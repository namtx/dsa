package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lis.lengthOfLIS(nums));
        System.out.println(lis.lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            int max_val = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int index = lowerBound(list, num);
                list.set(index, num);
            }
        }

        return list.size();
    }

    private int lowerBound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
