package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode left = invalidTreeNode(root.left, root.val, Integer.MIN_VALUE);
        TreeNode right = invalidTreeNode(root.right, Integer.MAX_VALUE, root.val);
        if (left != null && right != null) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        } else if (left != null) {
            int tmp = root.val;
            root.val = left.val;
            left.val = tmp;
        } else if (right != null) {
            int tmp = root.val;
            root.val = right.val;
            right.val = tmp;
        }
    }

    private TreeNode invalidTreeNode(TreeNode root, int max, int min) {
        if (root == null) return null;
        if (root.val < min || root.val > max) return root;

        TreeNode left = invalidTreeNode(root.left, root.val, min);
        TreeNode right = invalidTreeNode(root.right, max, root.val);
        if (left != null && right != null) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;

            return null;
        } else if (left != null) {
            return left;
        } else return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(3), new TreeNode(1));

        new RecoverBinarySearchTree().recoverTree(root);
        System.out.println(root);
    }
}
