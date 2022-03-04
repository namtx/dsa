package dev.namtx.leetcode;

public class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for (int k = i + 1; k < isConnected[i].length; k++) {
            if (k != i && isConnected[i][k] == 1 && !visited[k]) {
                dfs(k, isConnected, visited);
            }
        }
    }
}
