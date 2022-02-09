package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[][] testCases = new int[][]{
                {0, 1, 3, 12, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 3, 12},
                {1, 0},
                {0, 1},
                {1, 2},
                {1, 0, 1}
        };
        for (int[] testCase : testCases) {
            new MoveZeroes().moveZeroes(testCase);
            System.out.println(Arrays.toString(testCase));
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                if (nums[left] == 0) {
                    swap(nums, left, right);
                } else {
                    right++;
                }
                left++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
