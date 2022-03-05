package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        java.util.Arrays.sort(nums);
        backtrack(nums, 0, result, new java.util.ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> tempList) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(nums, i + 1, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubsetII().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
