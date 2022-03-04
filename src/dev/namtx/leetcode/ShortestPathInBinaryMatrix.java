package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInBinaryMatrix {
    private static final int[][] DIRS = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        if (grid.length == 1 && grid[0].length == 1) return 1;
        List<int[]> levels = new ArrayList<>();
        levels.add(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int ans = 1;

        while (!levels.isEmpty()) {
            List<int[]> nextLevels = new ArrayList<>();
            for (int[] level : levels) {
                for (int[] dir : DIRS) {
                    int x = level[0] + dir[0];
                    int y = level[1] + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    }

                    if (x == grid.length - 1 && y == grid[0].length - 1 && grid[x][y] == 0) {
                        return ans + 1;
                    } else {
                        nextLevels.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            levels = nextLevels;
            ans++;
        }

        return -1;
    }
}
