package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

public class LongestUnivaluePath {
    int ans = 0;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)));
        TreeNode root = new TreeNode(4, new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(4, null, new TreeNode(5)));

        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPathLength = 0;
        if (root.left != null && root.val == root.left.val) {
            leftPathLength = left + 1;
        }
        int rightPathLength = 0;
        if (root.right != null && root.val == root.right.val) {
            rightPathLength = right + 1;
        }
        ans = Math.max(ans, leftPathLength + rightPathLength);

        return Math.max(leftPathLength, rightPathLength);
    }
}
