package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * <p>
 * tags: sort, two pointers
 */
public class KdiffPairsInArray {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{3, 1, 4, 1, 5}, {2}},
                {{1, 2, 3, 4, 5}, {1}},
                {{1, 3, 1, 5, 4}, {0}},
                {{3, 1, 4, 1, 5}, {1}},
                {{1, 1, 1, 1, 1}, {0}},
                {{1, 1, 1, 1, 1}, {1}},
                {{1}, {1}},
                {{1, 2, 3, 4, 5}, {0}},
        };

        for (int[][] testCase : testCases) {
            System.out.println(new KdiffPairsInArray().findPairs(testCase[0], testCase[1][0]));
        }
    }

    public int findPairs(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] - nums[left] == k) {
                count++;
                while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    right++;
                }
                right++;
                left++;
            } else if (nums[right] - nums[left] > k) {
                left++;
                if (left == right) {
                    right++;
                }
            } else {
                while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    right++;
                }
                right++;
            }
        }

        return count;
    }
}
