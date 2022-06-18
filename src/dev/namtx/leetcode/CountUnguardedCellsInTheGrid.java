package dev.namtx.leetcode;

import java.util.Arrays;

public class CountUnguardedCellsInTheGrid {
    static final int GUARD = 2;
    static final int WALL = -2;
    static final int UNGUARDED = -1;
    static final int GUARDED = 1;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for (int[] row : mat) {
            Arrays.fill(row, UNGUARDED);
        }
        for (int[] wall : walls) {
            mat[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            mat[guard[0]][guard[1]] = GUARD;
        }
        for (int[] guard : guards) {
            // top
            mat[guard[0]][guard[1]] = GUARD;
            for (int i = guard[0] - 1; i >= 0; i--) {
                if (mat[i][guard[1]] == WALL || mat[i][guard[1]] == GUARD) break;
                mat[i][guard[1]] = GUARDED;
            }
            // bottom
            for (int i = guard[0] + 1; i < m; i++) {
                if (mat[i][guard[1]] == WALL || mat[i][guard[1]] == GUARD) break;
                mat[i][guard[1]] = GUARDED;
            }
            // left
            for (int i = guard[1] - 1; i >= 0; i--) {
                if (mat[guard[0]][i] == WALL || mat[guard[0]][i] == GUARD) break;
                mat[guard[0]][i] = GUARDED;
            }
            // right
            for (int i = guard[1] + 1; i < n; i++) {
                if (mat[guard[0]][i] == WALL || mat[guard[0]][i] == GUARD) break;
                mat[guard[0]][i] = GUARDED;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == UNGUARDED) ans++;
            }
        }

        return ans;
    }
}
