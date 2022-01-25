package dev.namtx.leetcode;


import dev.namtx.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * <p>
 * tags: tree, lca, bfs
 * <p>
 * Solution: find the two deepest nodes, then find the lca of them.
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));

        System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(root));
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = null;
        TreeNode right = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) left = node;
                if (i == size - 1) right = node;
                assert node != null;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return lca(root, left, right);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
