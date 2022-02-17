package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates, ans, new ArrayList<>(), target, 0);

        return ans;
    }

    public void helper(int[] candidates, List<List<Integer>> ans, List<Integer> current, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                helper(candidates, ans, current, target - candidates[i], i);
                current.remove(current.size() - 1);
            }
        }
    }
}
