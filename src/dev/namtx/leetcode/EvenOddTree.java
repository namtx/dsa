package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/even-odd-tree/
 */
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);
        while (levels.size() > 0) {
            List<TreeNode> nextLevels = new ArrayList<>();
            for (int i = 0; i < levels.size(); i++) {
                TreeNode node = levels.get(i);
                if ((node.val + level) % 2 == 0) return false;
                if (level % 2 == 0) {
                    if (i > 0 && node.val <= levels.get(i - 1).val) return false;
                } else {
                    if (i > 0 && node.val >= levels.get(i - 1).val) return false;
                }
                if (node.left != null) nextLevels.add(node.left);
                if (node.right != null) nextLevels.add(node.right);
            }
            level++;
            levels = nextLevels;
        }

        return true;
    }
}
