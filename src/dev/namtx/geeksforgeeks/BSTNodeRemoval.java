package dev.namtx.geeksforgeeks;

import dev.namtx.ds.TreeNode;

/**
 * Optimal version of remove a TreeNode in BST
 */
public class BSTNodeRemoval {
    public TreeNode remove(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val > val) {
            root.left = remove(root.left, val);
        } else if (root.val < val) {
            root.right = remove(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode successorParent = root;
                TreeNode successor = root.right;

                while(successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }

                if (successorParent != root) {
                    successorParent.left = successor.right;
                } else {
                    successorParent.right = successor.right;
                }

                root.val = successor.val;
            }
        }

        return root;
    }
}
