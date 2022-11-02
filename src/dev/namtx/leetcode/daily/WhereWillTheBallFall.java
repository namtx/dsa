package dev.namtx.leetcode.daily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall
 */
public class WhereWillTheBallFall {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};

        System.out.println(Arrays.toString(new WhereWillTheBallFall().findBall(grid)));
    }

    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans[i] = findBall(grid, 0, i);
        }

        return ans;
    }

    private int findBall(int[][] grid, int i, int j) {
        boolean up = true;

        while (i < grid.length && j < grid[0].length) {
            if (up && j == 0 && grid[i][j] == -1) return -1;
            if (up && j == grid[0].length - 1 && grid[i][j] == 1) return -1;
            if (up && grid[i][j] == 1 && grid[i][j + 1] == -1) return -1;
            if (up && grid[i][j] == -1 && grid[i][j - 1] == 1) return -1;

            if (up) {
                j += (grid[i][j] == 1) ? 1 : -1;
                up = false;
            } else {
                i += 1;
                up = true;
            }
        }

        return j;
    }
}
