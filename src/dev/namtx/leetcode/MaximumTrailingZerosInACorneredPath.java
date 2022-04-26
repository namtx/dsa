package dev.namtx.leetcode;

import java.util.Arrays;

public class MaximumTrailingZerosInACorneredPath {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{437, 230, 648, 905, 744, 416}, {39, 193, 421, 344, 755, 154}, {480, 200, 820, 226, 681, 663}, {658, 65, 689, 621, 398, 608}, {680, 741, 889, 297, 530, 547}, {809, 760, 975, 874, 524, 717}};
        MaximumTrailingZerosInACorneredPath solution = new MaximumTrailingZerosInACorneredPath();
        System.out.println(solution.maxTrailingZeros(grid));
    }

    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] factors = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                factors[i][j] = getPrimeFactors(grid[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(factors));
        int[][][] verticalPrefixSum = new int[n + 1][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                verticalPrefixSum[i + 1][j][0] = verticalPrefixSum[i][j][0] + getPrimeFactors(grid[i][j])[0];
                verticalPrefixSum[i + 1][j][1] = verticalPrefixSum[i][j][1] + getPrimeFactors(grid[i][j])[1];
            }
        }
        int[][][] horizontalPrefixSum = new int[n][m + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontalPrefixSum[i][j + 1][0] = horizontalPrefixSum[i][j][0] + getPrimeFactors(grid[i][j])[0];
                horizontalPrefixSum[i][j + 1][1] = horizontalPrefixSum[i][j][1] + getPrimeFactors(grid[i][j])[1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("===========================");
                System.out.println("i = " + i + ", j = " + j);
                // top-left
                int twosFromLeft = horizontalPrefixSum[i][j][0];
                int twosFromTop = verticalPrefixSum[i][j][0];
                int twosFromRight = horizontalPrefixSum[i][m][0] - horizontalPrefixSum[i][j + 1][0];
                int twosFromBottom = verticalPrefixSum[n][j][0] - verticalPrefixSum[i + 1][j][0];
                int fiveFromLeft = horizontalPrefixSum[i][j][1];
                int fiveFromTop = verticalPrefixSum[i][j][1];
                int fivesFromRight = horizontalPrefixSum[i][m][1] - horizontalPrefixSum[i][j + 1][1];
                int fivesFromBottom = verticalPrefixSum[n][j][1] - verticalPrefixSum[i + 1][j][1];

                // top-left
                int twos = twosFromLeft + twosFromTop;
                int fives = fiveFromLeft + fiveFromTop;
                System.out.println("TOP-LEFT, twos: " + twos + ", fives: " + fives);
                max = Math.max(max, Math.min(twos + factors[i][j][0], fives + factors[i][j][1]));

                // top-right
                twos = twosFromRight + twosFromTop;
                fives = fivesFromRight + fiveFromTop;
                System.out.println("TOP-RIGHT, twos: " + twos + ", fives: " + fives);
                max = Math.max(max, Math.min(twos + factors[i][j][0], fives + factors[i][j][1]));

                // bottom-left
                twos = twosFromLeft + twosFromBottom;
                fives = fiveFromLeft + fivesFromBottom;
                System.out.println("BOTTOM-LEFT, twos: " + twos + ", fives: " + fives);
                max = Math.max(max, Math.min(twos + factors[i][j][0], fives + factors[i][j][1]));

                // bottom-right
                twos = twosFromRight + twosFromBottom;
                fives = fivesFromRight + fivesFromBottom;
                System.out.println("BOTTOM-RIGHT, twos: " + twos + ", fives: " + fives);
                max = Math.max(max, Math.min(twos + factors[i][j][0], fives + factors[i][j][1]));
            }
        }

        return max;
    }

    private int[] getPrimeFactors(int n) {
        int[] result = new int[2];
        while (n % 2 == 0) {
            result[0]++;
            n /= 2;
        }
        while (n % 5 == 0) {
            result[1]++;
            n /= 5;
        }
        return result;
    }
}
