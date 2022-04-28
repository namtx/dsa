package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        PathWithMinimumEffort p = new PathWithMinimumEffort();
        int[][] heights = new int[][]{
                {1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
        };
        System.out.println(p.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == heights.length - 1 && cur[1] == heights[0].length - 1) {
                return cur[2];
            }
            visited[cur[0]][cur[1]] = true;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) {
                    continue;
                }
                pq.offer(new int[]{x, y, Math.max(Math.abs(heights[x][y] - heights[cur[0]][cur[1]]), cur[2])});
            }
        }

        // unreachable
        return -1;
    }
}
