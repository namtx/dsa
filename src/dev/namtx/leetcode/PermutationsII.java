package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        helper(ans, new ArrayList<>(), nums, occurrences);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> cur, int[] nums, Map<Integer, Integer> occurrences) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();
            if (count == 0) continue;

            cur.add(n);
            occurrences.put(n, count - 1);
            helper(ans, cur, nums, occurrences);
            occurrences.put(n, count);
            cur.remove(cur.size() - 1);
        }
    }
}
