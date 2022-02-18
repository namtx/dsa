package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(ans, new ArrayList<>(), nums);

        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (curr.contains(num)) continue;
            curr.add(num);
            helper(ans, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
