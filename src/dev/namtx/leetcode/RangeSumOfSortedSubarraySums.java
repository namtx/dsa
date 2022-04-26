package dev.namtx.leetcode;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] sums = new int[n*(n+1)/2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums[index++] = prefixSum[j + 1] - prefixSum[i];
            }
        }
        Arrays.sort(sums);

        int ans = 0;
        for (int i = left-1; i <right; i++) {
            ans += sums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new RangeSumOfSortedSubarraySums().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }
}
