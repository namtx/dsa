package dev.namtx.leetcode.editor.en;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeVisitingAllPoints().new Solution();
        System.out.println(solution.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int[] current = points[0];
            int steps = 0;
            for (int i = 1; i < points.length; i++) {
                int[] point = points[i];
                int x = point[0];
                int y = point[1];
                int offsetX = x == current[0] ? 0 : x < current[0] ? -1 : 1;
                int offsetY = y == current[1] ? 0 : y < current[1] ? -1 : 1;
                while (current[0] != x && current[1] != y) {
                    steps++;
                    current[0] += offsetX;
                    current[1] += offsetY;
                }
                while (current[0] != x) {
                    steps++;
                    current[0] += offsetX;
                }
                while (current[1] != y) {
                    steps++;
                    current[1] += offsetY;
                }
            }

            return steps;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
