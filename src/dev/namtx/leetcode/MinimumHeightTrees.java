package dev.namtx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * <p>
 * https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
 * <p>
 * tags: graph, bfs, topological sort
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 6;

        System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) { // if graph contains only one node, return it
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adjacent = new ArrayList<>(n);

        for (int i = 0; i < n; i++) adjacent.add(new HashSet<>());
        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (adjacent.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int i : leaves) {
                for (int a : adjacent.get(i)) {
                    adjacent.get(a).remove(i);
                    if (adjacent.get(a).size() == 1) newLeaves.add(a);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}

