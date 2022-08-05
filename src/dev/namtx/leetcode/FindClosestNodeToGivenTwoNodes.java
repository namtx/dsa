package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-304/problems/find-closest-node-to-given-two-nodes/
 */
public class FindClosestNodeToGivenTwoNodes {
    public static void main(String[] args) {
        // System.out.println(new FindClosestNodeToGivenTwoNodes().closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
//        System.out.println(new FindClosestNodeToGivenTwoNodes().closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
        // [-1, 2, 7, 5, -1, 6, 2, 6]
        System.out.println(new FindClosestNodeToGivenTwoNodes().closestMeetingNode(new int[]{1,2,3,0,5,-1,1,6}, 2, 7));
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] distances1 = new int[edges.length];
        Arrays.fill(distances1, -1);
        boolean[] visited1 = new boolean[edges.length];
        int[] distances2 = new int[edges.length];
        Arrays.fill(distances2, -1);
        boolean[] visited2 = new boolean[edges.length];
        dfs(edges, visited1, node1, distances1, 0);
        dfs(edges, visited2, node2, distances2, 0);

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (distances1[i] != -1 && distances2[i] != -1) {
                int v = Math.max(distances1[i], distances2[i]);
                if (ans == -1) {
                    ans = i;
                    min = v;
                } else {
                    if (min > v) {
                        ans = i;
                        min = v;
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int[] edges, boolean[] visited, int node, int[] distances, int dist) {
        if (node == -1) return;
        if (visited[node]) return;
        distances[node] = dist;
        visited[node] = true;
        dfs(edges, visited, edges[node], distances, dist+1);
    }
}
