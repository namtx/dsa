package dev.namtx.leetcode.editor.en;

import com.sun.source.tree.Tree;
import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7)));

        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
        System.out.println(solution.isCompleteTree(root));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int level = 1;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            List<TreeNode> childNodes = new ArrayList<>();
            int nonNullChildNodeCount = 0;
            for (TreeNode node: nodes) {
                childNodes.add(node.left);
                if (node.left != null) nonNullChildNodeCount++;
                childNodes.add(node.right);
                if (node.right != null) nonNullChildNodeCount++;
            }
            if (nonNullChildNodeCount < level * 2) {
                int k = 0;
                int i = 0;
                while (i < childNodes.size()) {
                    if (childNodes.get(i) != null) {
                        k++;
                        i++;
                    } else {
                        if (k < nonNullChildNodeCount) return false;
                        break;
                    }
                }
                return true;
            } else {
                level++;
                nodes = childNodes;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
