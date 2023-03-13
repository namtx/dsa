package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        Solution solution = new SymmetricTree().new Solution();
        System.out.println(solution.isSymmetric(root));
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
        public boolean isSymmetric(TreeNode root) {
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                int left = 0;
                int right = nodes.size() - 1;
                List<TreeNode> childNodes = new ArrayList<>();
                while (left < right) {
                    TreeNode leftNode = nodes.get(left);
                    TreeNode rightNode = nodes.get(right);
                    if ((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null) || (leftNode != null && rightNode != null && leftNode.val != rightNode.val))
                        return false;
                    left++;
                    right--;
                }
                for (TreeNode node : nodes) {
                    if (node != null) {
                        childNodes.add(node.left);
                        childNodes.add(node.right);
                    }
                }

                nodes = childNodes;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
