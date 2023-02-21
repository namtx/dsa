package dev.namtx.leetcode.editor.en;

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        int[][] mat = new int[][]{
                {1}, {2}, {3}
        };
        System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int[][] dirs = {
                {-1, 1}, {1, -1}
        };

        public int[] findDiagonalOrder(int[][] mat) {
            int i = 0;
            int j = 0;
            int n = mat.length;
            int m = mat[0].length;
            int[] ans = new int[m * n];
            int count = 0;
            int dir = 0;
            while (i < n && j < m) {
                ans[count++] = mat[i][j];
                i += dirs[dir][0];
                j += dirs[dir][1];
                boolean needRedirect = false;
                if (i == -1) {
                    if (j == m) {
                        i += 2;
                        j = m - 1;
                    } else {
                        i = 0;
                    }
                    needRedirect = true;
                } else if (j == -1) {
                    if (i == n) {
                        i = n - 1;
                        j += 2;
                    } else {
                        j = 0;
                    }
                    needRedirect = true;
                } else if (i == n) {
                    i = n - 1;
                    j += 2;
                    needRedirect = true;
                } else if (j == m) {
                    j = m - 1;
                    i += 2;
                    needRedirect = true;
                }
                if (needRedirect) {
                    dir = dir == 0 ? 1 : 0;
                }
            }

            ans[ans.length - 1] = mat[n - 1][m - 1];
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
