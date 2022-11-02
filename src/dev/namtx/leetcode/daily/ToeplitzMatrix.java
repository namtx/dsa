package dev.namtx.leetcode.daily;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(matrix));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int c, r, i, j = 0;

        for (i = n-1; i >= 0; i--) {
            int num = matrix[i][0];
            c = 0;
            r = 0;
            j = 0;
            while(c+j <= m-1 && r+i <= n-1) {
                if (matrix[i + r][j+c] != num) {
                    return false;
                }
                c++;
                r++;
            }
        }

        for (j = 1; j < m; j++) {
            int num = matrix[0][j];
            c = 0;
            r = 0;
            i = 0;
            while(c + j <= m-1 && r + i <= n-1) {
                if (matrix[r+i][c+j] != num) return false;
                r++;
                c++;
            }
        }

        return true;
    }
}
