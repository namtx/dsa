package dev.namtx.leetcode.daily;

import com.sun.source.tree.Tree;
import dev.namtx.ds.TreeNode;

public class MaximumProductOfSplitBinaryTree {
    private static final int MOD = 1_000_000_007;
    int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))));
        System.out.println(new MaximumProductOfSplitBinaryTree().maxProduct(root));
    }

    public int maxProduct(TreeNode root) {
        int total = sum(root);
        return maxProduct(root, total);
    }

    private int maxProduct(TreeNode root, int total) {
        if (root == null) {
            return 0;
        }
        // cut left
        int leftSum = sum(root.left);
        int leftProduct = ((leftSum % MOD) * ((total-leftSum) % MOD)) % MOD;
        int rightSum = sum(root.right);
        int rightProduct = ((rightSum%MOD) * ((total-rightSum) % MOD)) % MOD;
        int m = Math.max(leftProduct, rightProduct);
        max = Math.max(max, m);
        max = Math.max(max, maxProduct(root.left, total));
        max = Math.max(max, maxProduct(root.right, total));
        return max;
    }
    public int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
