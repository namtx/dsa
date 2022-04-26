package dev.namtx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
 */
public class LongestPathWithDifferentAdjacentCharacters {
    int max = 1;

    public static void main(String[] args) {
        int[] parent = new int[]{-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        System.out.println(new LongestPathWithDifferentAdjacentCharacters().longestPath(parent, s));
    }

    public int longestPath(int[] parent, String s) {
        Map<Integer, TreeNode> tree = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            TreeNode p = tree.computeIfAbsent(parent[i], TreeNode::new);
            TreeNode child = tree.computeIfAbsent(i, TreeNode::new);
            p.children.add(child);
        }
        boolean[] visited = new boolean[parent.length];

        for (int i = 0; i < parent.length; i++) {
            if (!visited[i]) {
                longestPath(tree.get(i), s, visited);
            }
        }

        return max;
    }

    private int longestPath(TreeNode parent, String s, boolean[] visited) {
        visited[parent.index] = true;
        if (parent.children.size() == 0) {
            return 1;
        }
        if (parent.children.size() == 1) {
            if (s.charAt(parent.children.get(0).index) != s.charAt(parent.index)) {
                int l = longestPath(parent.children.get(0), s, visited);
                max = Math.max(max, l + 1);
                return l + 1;
            } else {
                return 1;
            }
        }
        int[] longest = new int[parent.children.size()];
        for (int i = 0; i < parent.children.size(); i++) {
            TreeNode child = parent.children.get(i);
            if (s.charAt(child.index) != s.charAt(parent.index)) {
                longest[i] = longestPath(child, s, visited);
            }
        }

        Arrays.sort(longest);

        int l1 = longest[longest.length - 1];
        int l2 = longest[longest.length - 2];
        max = Math.max(max, l1 + l2 + 1);
        return l1 + 1;
    }

    static class TreeNode {
        public int index;
        public List<TreeNode> children;

        public TreeNode(int index) {
            this.index = index;
            this.children = new ArrayList<>();
        }
    }
}
