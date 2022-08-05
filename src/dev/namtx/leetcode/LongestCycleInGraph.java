package dev.namtx.leetcode;

import java.util.HashMap;

public class LongestCycleInGraph {
    int max = -1;

    public static void main(String[] args) {
        System.out.println(new LongestCycleInGraph().longestCycle(new int[]{-1, 4, -1, 2, 0, 4}));
    }

    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) continue;
            HashMap<Integer, Integer> m = new HashMap<>();

            for (int node = i, dist = 0; node != -1; node = edges[node]) {
                if (m.containsKey(node)) {
                    max = Math.max(max, dist - m.get(node));
                    break;
                }
                if (visited[node]) break;
                visited[node] = true;
                m.put(node, dist++);
            }
        }
        return max;
    }
}
