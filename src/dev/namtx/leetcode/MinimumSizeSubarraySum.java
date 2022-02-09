package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * tags: two pointers, prefix-sum
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{2, 3, 1, 2, 4, 3}, {7}},
                {{2, 3, 1, 2, 4, 3}, {8}},
                {{2, 3, 1, 2, 4, 3}, {9}},
                {{2, 3, 1, 2, 4, 3}, {10}},
                {{2, 3, 1, 2, 4, 3}, {20}},
                {{1}, {2}},
                {{1, 1}, {2}},
                {{1, 1, 1, 1, 1, 1, 1, 1}, {11}},
        };

        for (int[][] testCase : testCases) {
            System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(testCase[1][0], testCase[0]));
        }
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        int[] prefixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = (i == 0) ? nums[i] : prefixSum[i - 1] + nums[i];
        }

        int left = 0;
        int right = 0;
        int m;
        boolean found = false;

        while (right < nums.length) {
            while (right < nums.length) {
                if (prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]) >= target) {
                    break;
                }
                right++;
            }

            if (right == nums.length) {
                break;
            }

            int s = prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
            while (s >= target) {
                left++;
                s = s - (left == 0 ? 0 : prefixSum[left - 1]);
            }
            m = right - left + 2;
            found = true;
            min = Math.min(m, min);
        }

        return !found ? 0 : min;
    }
}
