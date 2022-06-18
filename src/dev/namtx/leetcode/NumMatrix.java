package dev.namtx.leetcode;

public class NumMatrix {
    private final int[][] prefixRow;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.prefixRow = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                prefixRow[i][j] = prefixRow[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        System.out.println(new NumMatrix(matrix).sumRegion(1, 2, 2, 4));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += prefixRow[i][col2 + 1] - prefixRow[i][col1];
        }
        return sum;
    }
}
