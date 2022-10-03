package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/contest/weekly-contest-313/problems/maximum-sum-of-an-hourglass/
 */
public class MaximumSumOfAnHourglass {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};

        System.out.println(new MaximumSumOfAnHourglass().maxSum(grid));
    }

    public int maxSum(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= grid.length-3; i++) {
            for (int j = 2; j <= grid[0].length-1; j++) {
                int sum = 0;
                // first line
                sum += (grid[i][j-2] + grid[i][j-1] + grid[i][j]);
                // center point
                sum += grid[i+1][j-1];
                // last line
                sum += (grid[i+2][j-2] + grid[i+2][j-1] + grid[i+2][j]);

                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
