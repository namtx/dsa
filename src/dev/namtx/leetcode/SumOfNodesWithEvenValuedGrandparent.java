package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                6,
                new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))),
                new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5)))
        );
        System.out.println(new SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(root));
    }

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (parent != null && parent.val % 2 == 0) {
            if (root.left != null) ans += root.left.val;
            if (root.right != null) ans += root.right.val;
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
