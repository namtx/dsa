package dev.namtx.leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    private static final int[][] DIRS = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public static void main(String[] args) {
        char[][] maze = new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        System.out.println(new NearestExitFromEntranceInMaze().nearestExit(maze, new int[]{1, 0}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int i = entrance[0];
        int j = entrance[1];
        maze[i][j] = '+'; // mark the entrance as visited

        Queue<int[]> queue = new LinkedList<>();
        // x position, y position, steps
        queue.offer(new int[]{i, j, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : DIRS) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.') {
                    if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
                        return current[2] + 1;
                    }
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y, current[2] + 1});
                }
            }
        }

        return -1;
    }
}
