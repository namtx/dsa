package dev.namtx.leetcode;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {3},
                {2, 4}, {1}, {0, 4}, {1, 3}
        };
        System.out.println(new IsGraphBipartite().isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] isASet = new int[n]; // 1 mean a, -1 mean b
        for (int i = 0; i < n; i++) {
            if (isASet[i] == 0 && !dfs(graph, i, isASet, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] isASet, int set) {
        isASet[i] = set;
        for (int j = 0; j < graph[i].length; j++) {
            int next = graph[i][j];
            if (isASet[next] != set) continue;
            if (isASet[next] == set && !dfs(graph, next, isASet, -set)) return false;
        }
        return false;
    }
}
