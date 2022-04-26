package dev.namtx.geeksforgeeks;

import dev.namtx.ds.TreeNode;

import java.util.Stack;

public class ConstructBSTFromGivenPreorderTraversal {
    Index index = new Index();

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 1, 7, 40, 50};
        TreeNode root = new ConstructBSTFromGivenPreorderTraversal().construct(nums);
        System.out.println(root);
    }

    public TreeNode construct(int[] nums) {
//        return helper(nums, 0, nums.length - 1);
//        return helper2(nums, Integer.MAX_VALUE, Integer.MIN_VALUE, index);
        return helper3(nums);
    }

    // Time complexity: O(n^2)
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        TreeNode root = new TreeNode(nums[start]);
        int i;
        for (i = start + 1; i <= end; i++) {
            if (nums[i] > nums[start]) break;
        }
        root.right = helper(nums, i, end);
        root.left = helper(nums, start + 1, i - 1);

        return root;
    }

    // Time complexity: O(n)
    private TreeNode helper2(int[] nums, int max, int min, Index preIndex) {
        if (preIndex.index >= nums.length) return null;
        int val = nums[preIndex.index];

        TreeNode root = null;
        if (val > min && val < max) {
            root = new TreeNode(val);
            preIndex.index = preIndex.index + 1;
            if (preIndex.index < nums.length) {
                root.left = helper2(nums, val, min, preIndex);
            }
            if (preIndex.index < nums.length) {
                root.right = helper2(nums, max, val, preIndex);
            }
        }

        return root;
    }

    private TreeNode helper3(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(nums[0]);
        stack.push(root);

        for (int i = 1; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            if (stack.peek().val > nums[i]) {
                stack.peek().left = node;
                stack.push(node);
            } else {
                TreeNode current = stack.peek();
                while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                    current = stack.pop();
                }
                current.right = node;
            }
            stack.push(node);
        }

        return root;
    }

    static class Index {
        int index = 0;
    }
}
