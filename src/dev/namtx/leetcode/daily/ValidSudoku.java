package dev.namtx.leetcode.daily;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][][] squared = new boolean[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                // rows
                if (rows[i][num]) return false;
                else rows[i][num] = true;
                // columns
                if (columns[j][num]) return false;
                else columns[j][num] = true;
                // squared
                // find row of square
                int row = i / 3;
                int col = j / 3;
                if (squared[row][col][num]) return false;
                else squared[row][col][num] = true;
            }
        }

        return true;
    }
}
