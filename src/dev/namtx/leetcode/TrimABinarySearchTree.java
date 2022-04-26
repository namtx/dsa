package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
            3,
            new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)),
            new TreeNode(4)
        );
        System.out.println(new TrimABinarySearchTree().trimBST(root, 1, 3));
    }
}
