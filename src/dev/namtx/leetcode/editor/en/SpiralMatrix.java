package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[][] dirs = {
                    {0, 1}, // left -> right
                    {1, 0}, // top -> bottom
                    {0, -1}, // right -> left
                    {-1, 0} // bottom -> top
            };
            int n = matrix.length;
            int m = matrix[0].length;
            int left = 0;
            int right = m - 1;
            int top = 0;
            int bottom = n - 1;
            int dir = 0;
            int i = 0;
            int j = 0;

            List<Integer> ans = new ArrayList<>();
            while (j >= left && j <= right && i >= top && i <= bottom) {
                ans.add(matrix[i][j]);
                if ((dir % 4 == 0 && j == right)) {
                    dir++;
                    top++;
                }
                if (dir % 4 == 1 && i == bottom) {
                    dir++;
                    right--;
                }
                if (dir % 4 == 2 && j == left) {
                    dir++;
                    bottom--;
                }
                if (dir % 4 == 3 && i == top) {
                    dir++;
                    left++;
                }
                i += dirs[dir % 4][0];
                j += dirs[dir % 4][1];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
