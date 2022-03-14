package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BinarySearchTreeToGreaterSumTree {
    int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)))
        );

        System.out.println(new BinarySearchTreeToGreaterSumTree().bstToGst(root));
    }

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root.right != null) {
            dfs(root.right);
        }

        int prev = root.val;
        root.val = root.val + sum;
        sum += prev;

        if (root.left != null) {
            dfs(root.left);
        }
    }
}
