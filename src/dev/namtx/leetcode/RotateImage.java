package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * <p>
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
