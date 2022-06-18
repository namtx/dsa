package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NetworkDelayTime {
    public static final int UNVISITED = 0;
    public static final int VISITING = 1;

    public static void main(String[] args) {
        int[][] times = new int[][]{
                {1, 2, 1}, {2, 3, 2}, {1, 3, 2}
        };
        System.out.println(new NetworkDelayTime().networkDelayTime(times, 3, 1));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] visited = new int[n + 1];
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] time : times) {
            nodes[time[0]].add(nodes[time[1]], time[2]);
        }
        Map<Node, Integer> fromK = new HashMap<>();
        dfs(fromK, nodes[k], visited, 0);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if(!fromK.containsKey(nodes[i])) return -1;
            ans = Math.max(ans, fromK.get(nodes[i]));
        }
        return ans;
    }

    public void dfs(Map<Node, Integer> fromK, Node node, int[] visited, int delay) {
        if (visited[node.val] != UNVISITED) return;
        visited[node.val] = VISITING;
        for (Map.Entry<Node, Integer> e : node.children.entrySet()) {
            fromK.put(e.getKey(), Math.min(fromK.getOrDefault(e.getKey(), Integer.MAX_VALUE), delay + e.getValue()));
            dfs(fromK, e.getKey(), visited, e.getValue());
        }
        visited[node.val] = UNVISITED;
    }

    static class Node {
        int val;
        Map<Node, Integer> children;

        Node(int val) {
            this.val = val;
            children = new HashMap<>();
        }

        void add(Node node, int time) {
            children.put(node, time);
        }
    }


}
