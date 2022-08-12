package dev.namtx.leetcode.daily;


import dev.namtx.ds.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
    
    TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid-1);
        root.right = build(nums, mid +1, end);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConvertSortedArrayToBinarySearchTree()
                .sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
