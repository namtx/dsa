package dev.namtx.leetcode;

import java.util.*;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        Set<Integer> restrictedSet = new HashSet<>();
        for (int r : restricted) {
            restrictedSet.add(r);
        }
        for (int[] edge : edges) {
            if (restrictedSet.contains(edge[0]) || restrictedSet.contains(edge[1])) continue;
            List<Integer> neighbors;
            if (m.containsKey(edge[0])) {
                neighbors = m.get(edge[0]);
            } else {
                neighbors = new ArrayList<>();
            }
            neighbors.add(edge[1]);
            m.put(edge[0], neighbors);
            if (m.containsKey(edge[1])) {
                neighbors = m.get(edge[1]);
            } else {
                neighbors = new ArrayList<>();
            }
            neighbors.add(edge[0]);
            m.put(edge[1], neighbors);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node]) continue;
            visited[node] = true;
            ans++;
            q.addAll(m.getOrDefault(node, new ArrayList<>()));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {0,1},{1,2},{3,1},{4,0},{0,5},{5,6}
        };
        int[] restricted = new int[]{4,5};
        int n = 7;
        System.out.println(new ReachableNodesWithRestrictions().reachableNodes(n, edges, restricted));
    }
}
