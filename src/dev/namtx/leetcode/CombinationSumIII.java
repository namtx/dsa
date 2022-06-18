package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), k, n, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int k, int n, int num) {
        if (n < 0) return;
        if (current.size() > k) return;
        if (n == 0 && current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = num + 1; i <= 9; i++) {
            current.add(i);
            backtrack(res, current, k, n - i, i);
            current.remove(current.size() - 1);
        }
    }
}
