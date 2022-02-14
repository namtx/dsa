package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            helper(nums, 0, i, new ArrayList<>(), ans);
        }

        return ans;
    }

    private void helper(int[] nums, int start, int length, List<Integer> curr, List<List<Integer>> result) {
        if (length == 0) {
            result.add(new ArrayList<>());
            return;
        }
        if (curr.size() >= length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, i + 1, length, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
