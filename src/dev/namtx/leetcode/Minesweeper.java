package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minesweeper/
 */
public class Minesweeper {
    static final int[][] DIRS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
        };

        System.out.println(Arrays.deepToString(new Minesweeper().updateBoard(board, new int[]{3, 0})));
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        if (board[r][c] == 'E') {
            reveal(board, r, c);
        }

        return board;
    }

    private void reveal(char[][] board, int r, int c) {
        if (board[r][c] == 'E') {
            int bombs = 0;
            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if (board[nr][nc] == 'M') {
                        bombs++;
                    }
                }
            }
            if (bombs > 0) {
                board[r][c] = (char) (bombs + '0');
            } else {
                board[r][c] = 'B';
                for (int[] dir : DIRS) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                        reveal(board, nr, nc);
                    }
                }
            }
        }
    }
}
