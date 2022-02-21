package dev.namtx.leetcode;

import java.util.Arrays;

public class FloodFill {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final int VISITED = 1;
    static final int UNVISITED = 0;

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
        };
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, 0, 0, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visited = new int[image.length][image[0].length];
        fill(image, sr, sc, image[sr][sc], newColor, visited);

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor, int[][] visited) {
        visited[sr][sc] = VISITED;
        image[sr][sc] = newColor;

        for (int[] dir : DIRS) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && visited[nr][nc] == UNVISITED && image[nr][nc] == oldColor) {
                fill(image, nr, nc, oldColor, newColor, visited);
            }
        }
    }
}

