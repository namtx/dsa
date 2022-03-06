package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        System.out.println(new CreateBinaryTreeFromDescriptions().createBinaryTree(
                new int[][]{
                        {20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}
                }
        ));
        System.out.println(new CreateBinaryTreeFromDescriptions().createBinaryTree(
                new int[][]{
                        {1, 2, 1}, {2, 3, 0}, {3, 4, 1}
                }
        ));
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> m = new HashMap<>();
        Map<Integer, Boolean> parents = new HashMap<>();

        for (int[] description : descriptions) {
            TreeNode parent = m.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = m.getOrDefault(description[1], new TreeNode(description[1]));
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            m.put(description[0], parent);
            m.put(description[1], child);
            if (!parents.containsKey(description[0])) {
                parents.put(description[0], true);
            }
            parents.put(description[1], false);
        }

        for (int val : parents.keySet()) {
            if (parents.get(val)) return m.get(val);
        }

        return null;
    }
}
