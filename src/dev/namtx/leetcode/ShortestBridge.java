package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-bridge/
 * <p>
 * tags: dfs, bfs, matrix
 * <p>
 * Solution: dfs to find the island and bfs to expand that island until meet the other island.
 */
public class ShortestBridge {
    public static final int[][] MOVES = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public static final int[][] MOVES2 = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,0,0,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,0,0}
        };
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }

    public int shortestBridge(int[][] grid) {
        int x = 0;
        int y = 0;
        boolean found = false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (x = 0; x < grid.length; x++) {
            for (y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        List<Integer[]> border = new ArrayList<>();
        dfs(x, y, grid, visited, border);

        int bridgeLength = 0;

        while (true) {
            ArrayList<Integer[]> newBorder = new ArrayList<>();

            for (Integer[] b : border) {
                visited[b[0]][b[1]] = true;
                for (int[] move : MOVES2) {
                    int dx = b[0] + move[0];
                    int dy = b[1] + move[1];
                    if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && !visited[dx][dy]) {
                        if (grid[dx][dy] == 1) {
                            return bridgeLength;
                        } else if (grid[dx][dy] == 0) {
                            newBorder.add(new Integer[]{dx, dy});
                        }
                    }
                }
            }

            bridgeLength++;

            border = newBorder;
        }
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited, List<Integer[]> border) {
        // mark all cells of one island as 2
        visited[x][y] = true;
        grid[x][y] = 2;

        int c = 0;
        List<Integer[]> oneCells = new ArrayList<>();

        // dfs through all adjacent cell
        for (int[] move : MOVES) {
            int dx = x + move[0];
            int dy = y + move[1];

            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && !visited[dx][dy]) {
                c++;
                if (grid[dx][dy] == 1) {
                    oneCells.add(new Integer[]{dx, dy});
                }
            }
        }

        if (oneCells.size() == 0 || c != oneCells.size()) {
            border.add(new Integer[]{x, y});
        }

        for (Integer[] cell : oneCells) {
            dfs(cell[0], cell[1], grid, visited, border);
        }
    }
}
