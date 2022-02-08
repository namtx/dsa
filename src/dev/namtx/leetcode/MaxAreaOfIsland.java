package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    static final int VISITING = 0;
    static final int VISITED = 1;
    static final int UNVISITED = -1;
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };

        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] v = new int[grid.length][grid[0].length];
        for (int[] r : v) {
            Arrays.fill(r, UNVISITED);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && v[i][j] == UNVISITED) {
                    int area = area(grid, i, j, v);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int area(int[][] grid, int i, int j, int[][] v) {
        v[i][j] = VISITED;
        List<int[]> adjacent = new ArrayList<>();
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && v[x][y] == UNVISITED && grid[x][y] == 1) {
                adjacent.add(new int[]{x, y});
                v[x][y] = VISITING;
            }
        }
        if (adjacent.size() == 0) {
            return 1;
        } else {
            int a = 1;
            for (int[] adj : adjacent) {
                a += area(grid, adj[0], adj[1], v);
            }

            return a;
        }
    }
}
