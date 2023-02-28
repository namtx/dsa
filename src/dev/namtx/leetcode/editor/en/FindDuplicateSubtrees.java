package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> ans = new ArrayList<>();
            preOrder(root, ans, new HashMap<>());

            return ans;
        }

        private String preOrder(TreeNode root, List<TreeNode> ans, Map<String, Integer> serializedNodes) {
            if (root == null) return "";
            String left = preOrder(root.left, ans, serializedNodes);
            String right = preOrder(root.right, ans, serializedNodes);

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            sb.append("-");
            sb.append(left);
            sb.append("-");
            sb.append(right);
            String serialized = sb.toString();
            int count = serializedNodes.getOrDefault(serialized, 0);
            if (count == 1) {
                ans.add(root);
            }
            serializedNodes.put(serialized, count + 1);

            return serialized;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
