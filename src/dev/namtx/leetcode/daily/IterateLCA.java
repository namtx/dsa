package dev.namtx.leetcode.daily;

import dev.namtx.ds.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/1347857/C%2B%2BJavaPython-Iterate-in-BST-Picture-explain-Time%3A-O(H)-Space%3A-O(1)
 */
public class IterateLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);

        while(root != null) {
            if (root.val < small) {
                root = root.right;
            } else if (root.val > large) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }
}
