package dev.namtx.leetcode.editor.en;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        Solution solution = new NumberOfEnclaves().new Solution();
        System.out.println(solution.numEnclaves(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRS = {
                {-1,0},{0,1},{1,0},{0,-1}
        };
        public int numEnclaves(int[][] grid) {
            int ans = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j] && grid[i][j] == 1 && (i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1)) {
                        dfs(i, j, grid, visited);
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) ans++;
                    
                }
            }

            return ans;
        }

        private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
            visited[x][y] = true;

            for(int[] dir: DIRS) {
                int dx = x+dir[0];
                int dy = y + dir[1];
                if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && !visited[dx][dy] && grid[dx][dy] == 1) {
                    dfs(dx, dy, grid, visited);
                }
            }
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)

}
