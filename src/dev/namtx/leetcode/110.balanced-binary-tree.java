package dev.namtx.leetcode;
/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start

import dev.namtx.ds.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(height(root.left) - height(root.right)) >= 2) return false;

        return isBalanced(root.left) && isBalanced(root.right);  
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
// @lc code=end
