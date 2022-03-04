package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };
        System.out.println(Arrays.deepToString(graph));
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        helper(graph, path, 0, result, visited);
        return result;
    }

    private void helper(int[][] graph, List<Integer> path, int curr, List<List<Integer>> result, boolean[] visited) {
        path.add(curr);
        visited[curr] = true;
        if (curr == graph.length - 1) {
            result.add(new ArrayList<>(path));
            visited[curr] = false;
            return;
        }

        for (int next : graph[curr]) {
            if (!visited[next]) {
                helper(graph, path, next, result, visited);
                path.remove(path.size() - 1);
            }
        }
        visited[curr] = false;
    }
}
