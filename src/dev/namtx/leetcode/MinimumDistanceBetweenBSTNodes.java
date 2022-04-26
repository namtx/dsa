package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        if (root.left != null && root.right != null) {
            int diff = Math.min(root.val - root.left.val, root.right.val - root.val);
            return Math.min(diff, Math.min(minDiffInBST(root.left), minDiffInBST(root.right)));
        } else if (root.left != null) {
            int diff = root.val - root.left.val;
            return Math.min(diff, minDiffInBST(root.left));
        } else if (root.right != null) {
            int diff = root.right.val - root.val;
            return Math.min(diff, minDiffInBST(root.right));
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(6);
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(root));
    }
}
