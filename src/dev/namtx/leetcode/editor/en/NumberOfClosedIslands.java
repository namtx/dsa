package dev.namtx.leetcode.editor.en;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        Solution solution = new NumberOfClosedIslands().new Solution();
        System.out.println(solution.closedIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        int ans = 0;
        boolean closed;

        public int closedIsland(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0 && !visited[i][j]) {
                        closed = true;
                        dfs(i, j, grid, visited);
                        if (closed) ans++;
                    }
                }
            }

            return ans;
        }

        private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
            visited[x][y] = true;
            if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) {
                closed = false;
            }
            for (int[] dir : dirs) {
                int dx = dir[0] + x;
                int dy = dir[1] + y;

                if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && !visited[dx][dy] && grid[dx][dy] == 0) {
                    dfs(dx, dy, grid, visited);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
