package dev.namtx.leetcode;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0},
                }
        ));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];

        // last colum
        for (int i = r - 1; i >= 0; i--) {
            if (obstacleGrid[i][c - 1] == 1) {
                break;
            }
            dp[i][c - 1] = 1;
        }
        // last row
        for (int j = r - 1; j >= 0; j--) {
            if (obstacleGrid[r - 1][j] == 1) {
                break;
            }
            dp[r - 1][j] = 1;
        }

        for (int j = c - 2; j >= 0; j--) {
            for (int i = r - 2; i >= 0; i--) {
                if (obstacleGrid[i + 1][j] == 1 && obstacleGrid[i][j + 1] == 1) {
                    dp[i][j] = 0;
                } else if (obstacleGrid[i + 1][j] == 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (obstacleGrid[i][j + 1] == 1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
