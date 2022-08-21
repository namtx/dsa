package dev.namtx.leetcode.contest;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-307/problems/amount-of-time-for-binary-tree-to-be-infected/
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adjacents = new HashMap<>();
        buildAdjacents(root, adjacents);

        List<Integer> infecting = new ArrayList<>();
        infecting.add(start);
        Map<Integer, Boolean> infected = new HashMap<>();

        int ans = 0;
        while (!infecting.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            for (int node : infecting) {
                infected.put(node, true);
                for (int adj : adjacents.getOrDefault(node, new ArrayList<>())) {
                    if (!infected.getOrDefault(adj, false)) {
                        l.add(adj);
                    }
                }
            }
            infecting = l;
            if (!l.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }

    private void buildAdjacents(TreeNode root, Map<Integer, List<Integer>> adjs) {
        List<Integer> adj = adjs.getOrDefault(root.val, new ArrayList<>());
        adjs.put(root.val, adj);
        if (root.left != null) {
            adj.add(root.left.val);
            List<Integer> left = adjs.getOrDefault(root.left.val, new ArrayList<>());
            left.add(root.val);
            adjs.put(root.left.val, left);
            buildAdjacents(root.left, adjs);
        }
        if (root.right != null) {
            adj.add(root.right.val);
            List<Integer> left = adjs.getOrDefault(root.right.val, new ArrayList<>());
            left.add(root.val);
            adjs.put(root.right.val, left);
            buildAdjacents(root.right, adjs);
        }
    }
}
