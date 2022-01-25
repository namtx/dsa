package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        root.right = new TreeNode(15, null, new TreeNode(18));

        System.out.println(new RangeSumOfBST().rangeSumBST(root, 7, 15));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        return sum + dfs(root.left, low, high) + dfs(root.right, low, high);
    }
}
