package dev.namtx.leetcode.editor.en;

import com.sun.source.tree.Tree;
import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null,    new TreeNode(9, new TreeNode(7), null)));
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        System.out.println(solution.widthOfBinaryTree(root));
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        TreeNode[] nodes = new TreeNode[1];
        nodes[0] = root;
        int max = 1;
        while (true) {
            TreeNode[] child = new TreeNode[nodes.length*2];
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    child[i*2] = nodes[i].left;
                    child[i*2+1] = nodes[i].right;
                }
            }
            int i = 0;
            int j = child.length-1;
            while(i < child.length-1 && child[i] == null) i++;
            while(j >= 0 && child[j] == null) j--;
            if (j >= i) {
                max = Math.max(max, j - i + 1);
                nodes = child;
            } else {
                return max;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
