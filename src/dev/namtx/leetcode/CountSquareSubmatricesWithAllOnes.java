package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                int mul = matrix[i - 1][j] * matrix[i - 1][j - 1] * matrix[i][j - 1];
                if (mul != 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans += ints[j];
            }
        }

        return ans;
    }
}
