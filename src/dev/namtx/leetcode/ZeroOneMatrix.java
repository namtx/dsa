package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i,j});
                    res[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIRS) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && res[x][y] > res[cur[0]][cur[1]] + 1) {
                    res[x][y] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x,y});
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {0,1,1,1,1,1,1,1,1,1,0},
        };
        System.out.println(Arrays.deepToString(new ZeroOneMatrix().updateMatrix(mat)));
    }
}
