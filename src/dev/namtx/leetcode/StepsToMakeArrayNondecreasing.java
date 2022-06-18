package dev.namtx.leetcode;

import java.util.Stack;

public class StepsToMakeArrayNondecreasing {
    public static void main(String[] args) {
        System.out.println(new StepsToMakeArrayNondecreasing().totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
    }

    public int totalSteps(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int count = 0;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (s.isEmpty()) {
                    s.push(nums[i]);
                } else {
                    if (nums[i] > s.peek()) {
                        found = true;
                        s.pop();
                    }
                    s.push(nums[i]);
                }
            }
            if (found) count++;
            int[] newNums = new int[s.size()];
            int i = 0;
            while (!s.isEmpty()) {
                newNums[i++] = s.pop();
            }

            nums = newNums;
        }

        return count;
    }
}
