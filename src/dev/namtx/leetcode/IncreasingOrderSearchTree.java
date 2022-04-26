package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9)))
        );
        root = new IncreasingOrderSearchTree().increasingBST(root, null);
        System.out.println(root);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        if (root.left == null) {
            root.right = increasingBST(root.right);
            return root;
        } else {
            TreeNode node = increasingBST(root.left);
            root.right = increasingBST(root.right);
            root.left = null;
            TreeNode current = node;
            while (current.right != null) {
                current = current.right;
            }
            current.right = root;
            return node;
        }
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;

        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
