package dev.namtx.leetcode;

import java.util.Stack;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root.left == null && root.right == null && k != 0) return -1;
        Stack<TreeNode> stack = new Stack<>();
        return kthSmallest(stack, root, k);
    }

    private int kthSmallest(Stack<TreeNode> s, TreeNode root, int k) {
        if (k == 0) return root.val;
        TreeNode curr = root;
        while (k >= 1) {
            while (curr.left != null) {
                s.push(curr);
                curr = curr.left;
            }
            s.push(curr);

            while (!s.isEmpty()) {
                TreeNode smallest = s.pop();
                if (k == 1) {
                    return smallest.val;
                }
                if (smallest.right == null) {
                    k--;
                } else {
                    return kthSmallest(s, smallest.right, k - 1);
                }
            }
        }

        return -1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
