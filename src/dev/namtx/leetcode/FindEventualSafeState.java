package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class FindEventualSafeState {
    public static final int SAFE = 2;
    public static final int UNSAFE = 1;
    public static final int UNVISITED = 0;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new FindEventualSafeState().eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> r = new ArrayList<>();
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, colors, graph)) {
                r.add(i);
            }
        }

        return r;
    }

    private boolean dfs(int node, int[] colors, int[][] graph) {
        if (colors[node] != UNVISITED) { // being visiting or visited
            return colors[node] == SAFE;
        }

        colors[node] = UNSAFE;

        for (int a : graph[node]) {
            if (colors[node] == SAFE) continue;

            if (colors[a] == UNSAFE || !dfs(a, colors, graph)) return false;
        }

        colors[node] = SAFE;

        return true;
    }
}
