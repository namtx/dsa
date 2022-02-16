package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
    static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][]{
                {2,2},
                {1,1},
                {0,0},
                {2,0},
        }));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> rottens = new ArrayList<>();
        int[][] visited = new int[m][n];

        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        if (rottens.isEmpty()) {
            return -1;
        } else if (rottens.size() == m * n) {
            return 0;
        }

        int time = 0;
        while (!rottens.isEmpty()) {
            time++;
            List<int[]> nextRottens = new ArrayList<>();
            for (int[] rotten : rottens) {
                grid[rotten[0]][rotten[1]] = 2;
                visited[rotten[0]][rotten[1]] = 1;
                for (int[] dir : DIRS) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == 0 && grid[x][y] == 1) {
                        visited[x][y] = -1;
                        nextRottens.add(new int[]{x, y});
                    }
                }
            }
            rottens = nextRottens;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time-1;
    }
}
