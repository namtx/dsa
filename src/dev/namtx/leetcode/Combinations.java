package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> ans = combinations.combine(4, 2);
        System.out.println(ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new java.util.ArrayList<>();

        helper(ans, new ArrayList<>(), 1, n, k);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> cur, int start, int n, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(ans, cur, i + 1, n, k);
            cur.remove(cur.size() - 1);
        }
    }
}
