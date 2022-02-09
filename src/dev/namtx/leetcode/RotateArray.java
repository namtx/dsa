package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array
 */
public class RotateArray {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{1, 2, 3, 4, 5, 6, 7}, {3}},
                {{1, 2, 3, 4, 5, 6, 7}, {4}},
                {{-1, -100, 3, 99}, {2}},
        };

        for (int[][] testCase : testCases) {
            new RotateArray().rotate(testCase[0], testCase[1][0]);
            System.out.println(Arrays.toString(testCase[0]));
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }

        // swap head
        for (int i = 0; i < k / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - 1 - i] = tmp;
        }
        // swap tail
        for (int i = k; i < k + (nums.length - k) / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i + k];
            nums[nums.length - 1 - i + k] = tmp;
        }
    }
}
