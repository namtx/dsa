package dev.namtx.leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimize-deviation-in-array/
 */
public class MinimizeDeviationInArray {
    public static void main(String[] args) {
        MinimizeDeviationInArray solution = new MinimizeDeviationInArray();
        int[] nums = {4, 1, 5, 20, 3};
        System.out.println(solution.minimumDeviation(nums));
    }

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                set.add(num * 2);
            } else set.add(num);
        }
        int diff = Integer.MAX_VALUE;
        while (true) {
            int min = set.first();
            int max = set.last();
            diff = Math.min(diff, max - min);
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else break;
        }

        return diff;
    }
}
