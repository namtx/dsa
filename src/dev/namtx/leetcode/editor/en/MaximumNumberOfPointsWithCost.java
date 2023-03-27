package dev.namtx.leetcode.editor.en;

public class MaximumNumberOfPointsWithCost {
    public static void main(String[] args) {
        int[][] points = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        Solution solution = new MaximumNumberOfPointsWithCost().new Solution();
        System.out.println(solution.maxPoints(points));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxPoints(int[][] points) {
            int n = points.length;
            int m = points[0].length;
            long[][] dp = new long[n][m];
            long[] prevRow = new long[m];
            for (int i = 0; i < m; i++) {
                prevRow[i] = points[0][i];
            }

            for (int i = 1; i < n; i++) {
                long[] left = new long[m];
                left[0] = prevRow[0];
                long[] right = new long[m];
                right[m - 1] = prevRow[m - 1];
                long[] currentRow = new long[m];
                for (int j = 1; j < m; j++) {
                    left[j] = Math.max(left[j - 1] - 1, prevRow[j]);
                }
                for (int j = m - 2; j >= 0; j--) {
                    right[j] = Math.max(right[j + 1] - 1, prevRow[j]);
                }
                for (int j = 0; j < m; j++) {
                    currentRow[j] = points[i][j] + Math.max(left[j], right[j]);
                }
                prevRow = currentRow;
            }

            long ans = Long.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, prevRow[j]);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
