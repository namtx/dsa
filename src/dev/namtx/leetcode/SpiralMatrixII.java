package dev.namtx.leetcode;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < (n / 2) + 1; i++) {
            // first row
            for (int j = i; j < (n - i) - 1; j++) {
                matrix[i][j] = num++;
            }
            // last column
            for (int j = i; j < (n - i) - 1; j++) {
                matrix[j][n - i - 1] = num++;
            }
            // last row
            for (int j = n - i - 1; j > i; j--) {
                matrix[n - i - 1][j] = num++;
            }
            // first column
            for (int j = n - i - 1; j > i; j--) {
                matrix[j][i] = num++;
            }
        }
        matrix[n / 2][n / 2] = num;

        return matrix;
    }
}
