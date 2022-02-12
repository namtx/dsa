package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 * <p>
 * tags: monotonic stack
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        System.out.println(
                new MaximumBinaryTree()
                        .constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5})
        );
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            TreeNode newNode = new TreeNode(nums[i]);
            while (!stack.isEmpty() && newNode.val > stack.peek().val) {
                newNode.right = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().left = newNode;
            }

            stack.push(newNode);
        }

        return stack.firstElement();
    }
}
