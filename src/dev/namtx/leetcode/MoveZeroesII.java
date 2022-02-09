package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroesII {
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
            new MoveZeroesII().moveZeroes(testCase);
            System.out.println(Arrays.toString(testCase));
        }
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
