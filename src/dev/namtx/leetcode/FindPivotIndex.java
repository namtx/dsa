package dev.namtx.leetcode;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 7, 3, 6, 5, 6},
                {1, 2, 3},
                {2, 1, -1}
        };

        for (int[] testCase : testCases) {
            System.out.println(new FindPivotIndex().pivotIndex(testCase));
        }
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        for (int i = 0; i < n; i++) {
            prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + nums[i];
        }
        for (int i = 0; i < n; i++) {
            suffixSum[i] = (i == 0 ? 0 : suffixSum[i - 1]) + nums[n - i - 1];
        }

        int i = 0;
        while (i < nums.length) {
            if (prefixSum[i] == suffixSum[n - 1 - i]) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
