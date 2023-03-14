package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution solution = new SumRootToLeafNumbers().new Solution();
        System.out.println(solution.sumNumbers(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int ans = 0;

        public int sumNumbers(TreeNode root) {
            sumNumbers(root, 0);
            return ans;
        }

        private void sumNumbers(TreeNode root, int currentNumber) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                ans += currentNumber * 10 + root.val;
                return;
            }
            sumNumbers(root.left, currentNumber * 10 + root.val);
            sumNumbers(root.right, currentNumber * 10 + root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
