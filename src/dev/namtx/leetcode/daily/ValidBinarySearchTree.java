package dev.namtx.leetcode.daily;

import dev.namtx.ds.TreeNode;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, int max, int min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        System.out.println(new ValidBinarySearchTree().isValidBST(root));
    }
}
