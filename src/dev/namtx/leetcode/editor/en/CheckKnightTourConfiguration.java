package dev.namtx.leetcode.editor.en;

public class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        Solution solution = new CheckKnightTourConfiguration().new Solution();
        int[][] grid = {
                {0,3,6},
                {5,8,1},
                {2,7,4},
        };
        System.out.println(solution.checkValidGrid(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] dirs = {
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1}
        };

        public boolean checkValidGrid(int[][] grid) {
            int[] position = {0, 0};
            int step = 0;
            int n = grid.length;
            if (grid[position[0]][position[1]] != 0) return false;
            while(step < n * n-1) {
                int prevStep = step;
                for (int[] dir: dirs) {
                    int dx = position[0] + dir[0];
                    int dy = position[1] + dir[1];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < n && grid[dx][dy] == step+1) {
                        step++;
                        position = new int[]{dx, dy};
                        break;
                    }
                }
                if (step == prevStep) return false;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
