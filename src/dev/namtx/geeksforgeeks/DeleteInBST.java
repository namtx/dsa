package dev.namtx.geeksforgeeks;

import dev.namtx.ds.TreeNode;

/**
 * Remove the node from the Binary Search Tree
 */
public class DeleteInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                50,
                new TreeNode(30, new TreeNode(20), new TreeNode(40)),
                new TreeNode(70, new TreeNode(60), new TreeNode(80))
        );
        root = new DeleteInBST().delete(root, 50);
        System.out.println(root);
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val < val) {
            // recursive to the right subtree
            root.right = delete(root.right, val);
        } else if (root.val > val) {
            // recursive to the left subtree
            root.left = delete(root.left, val);
        } else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // both the smallest in right subtree and biggest in the left subtree would work
            TreeNode smallestNodeFromRightSubtree = findTheSmallest(root.right);
            root.val = smallestNodeFromRightSubtree.val;
            root.right = delete(root.right, smallestNodeFromRightSubtree.val);
        }

        return root;
    }

    public TreeNode findTheSmallest(TreeNode root) {
        if (root.left == null) return root;

        return findTheSmallest(root.left);
    }
}
