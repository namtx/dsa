package dev.namtx.leetcode;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {
    static final int[][] DIRS = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    int max = 0;

    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] longest = new int[matrix.length][matrix[0].length];
        for (int[] row : longest) {
            Arrays.fill(row, 1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, visited, longest, matrix);
                }
            }
        }
        return max;
    }

    public int dfs(int i, int j, boolean[][] visited, int[][] longest, int[][] matrix) {
        if (visited[i][j]) return longest[i][j];

        int m = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                m = Math.max(m, dfs(x, y, visited, longest, matrix));
            }
        }
        longest[i][j] += m;
        visited[i][j] = true;
        max = Math.max(max, longest[i][j]);
        return longest[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix));
    }
}
