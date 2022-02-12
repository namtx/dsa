package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int s = numbers[i] + numbers[j];
            if (s == target) {
                return new int[]{i + 1, j + 1};
            } else if (s < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[2];
    }
}
