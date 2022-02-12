package dev.namtx.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-width-ramp
 * <p>
 * tags: monotonic stack
 */
public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[][] testCases = {
                {9, 8, 1, 0, 1, 9, 4, 0, 4, 1},
                {6, 0, 8, 2, 1, 5},
                {0, 1},
                {1, 0},
                {5, 4, 3, 2, 1, 0},
        };
        for (int[] testCase : testCases) {
            System.out.println(new MaximumWidthRamp().maxWidthRamp(testCase));
        }
    }

    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (monotonicStack.isEmpty() || nums[i] < nums[monotonicStack.peek()]) {
                monotonicStack.push(i);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && nums[i] >= nums[monotonicStack.peek()]) {
                max = Math.max(max, i - monotonicStack.pop());
            }
        }

        return max;
    }
}
