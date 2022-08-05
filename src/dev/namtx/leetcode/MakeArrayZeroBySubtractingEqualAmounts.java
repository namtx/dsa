package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class MakeArrayZeroBySubtractingEqualAmounts {
    public static void main(String[] args) {
        System.out.println(new MakeArrayZeroBySubtractingEqualAmounts().minimumOperations(new int[]{0}));
    }

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int sub = 0;
        int ans = 0;
        for (int num : nums) {
            if (num > sub) {
                ans++;
                sub = num;
            }
        }

        return ans;
    }
}
