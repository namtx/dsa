package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        boolean[][] marked = new boolean[n][n];
        backtrack(new ArrayList<>(), n, 0, marked);
        return ans;
    }

    private void backtrack(List<String> ret, int n, int row, boolean[][] marked) {
        if (row == n) {
            ans.add(new ArrayList<>(ret));
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j]) {

                }
            }
        }
    }

    private String printRow(int n, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            sb.append('.');
        }
        sb.append('Q');
        for (int i = c+1; i < n; i++) {
            sb.append('.');
        }

        return sb.toString();
    }

    private void mark(int i, int j, int n, boolean[][] marked) {
        // row
        for (int c = 0; c < n; c++) {
            marked[i][c]  = true;
        }
        // col
        for (int r = 0; r < n; r++) {
            marked[r][j] = true;
        }
        // /
//        for (i = 0; )
        // TODO: Finish
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
