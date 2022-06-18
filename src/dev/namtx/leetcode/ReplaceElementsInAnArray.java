package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 6};
        int[][] operations = new int[][]{
                {1, 3}, {4, 7}, {6, 1}
        };
        System.out.println(Arrays.toString(new ReplaceElementsInAnArray().arrayChange(nums, operations)));
    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }

        for (int[] operation : operations) {
            int position = m.get(operation[0]);
            m.put(operation[1], m.get(operation[0]));
            m.remove(operation[0]);
            nums[position] = operation[1];
        }

        return nums;
    }
}
