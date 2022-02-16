package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right = new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)));

        System.out.println(new PathSumII().pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        helper(ans, new ArrayList<>(), root, targetSum);

        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                helper(ans, path, root.left, targetSum - root.val);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                helper(ans, path, root.right, targetSum - root.val);
                path.remove(path.size() - 1);
            }
        }
    }
}
