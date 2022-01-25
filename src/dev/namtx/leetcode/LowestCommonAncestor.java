package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * tags: tree, lca
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        System.out.println(new LowestCommonAncestor().lca(4, 7, root).val);
    }

    public TreeNode lca(int p, int q, TreeNode root) {
        if (root == null) { // base case
            return null;
        }
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.val == p || root.val == q) {
            return root;
        }
        // Look for keys in left and right subtrees
        TreeNode left = lca(p, q, root.left);
        TreeNode right = lca(p, q, root.right);
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left != null && right != null) {
            return root;
        }
        // Otherwise, check if left subtree or right subtree is LCA
        return left != null ? left : right;
    }
}
