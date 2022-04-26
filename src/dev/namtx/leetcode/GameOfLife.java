package dev.namtx.leetcode;

import java.util.Arrays;

public class GameOfLife {
    static final int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}
    };
    public void gameOfLife(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            tmp[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = 0;
                int deads = 0;
                for (int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < tmp.length && y >= 0 && y < tmp[i].length) {
                        if (tmp[x][y] == 1) {
                            lives++;
                        } else {
                            deads++;
                        }
                    }
                }
                if (board[i][j] == 0) {
                    if (lives == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        new GameOfLife().gameOfLife(board);

        System.out.println(Arrays.deepToString(board));
    }
}
