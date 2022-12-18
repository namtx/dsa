package dev.namtx.leetcode.daily;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplitBinaryTree {
    static int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        List<Long> sums = new ArrayList<>();
        long total = helper(root, sums);
        long max = 0;
        for(long s : sums){
            long p = s * (total - s);
            max = Math.max(max, p);
        }
        return (int)(max % MOD);
    }

    public long helper(TreeNode node, List<Long> sums){
        if(node == null){
            return 0;
        }
        long left = helper(node.left, sums);
        long right = helper(node.right, sums);
        long sum = left + right + node.val;
        sums.add(sum);
        return sum;
    }
}
