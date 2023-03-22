package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumScoreOfAPathBetweenTwoCities {
    public static void main(String[] args) {
        Solution solution = new MinimumScoreOfAPathBetweenTwoCities().new Solution();
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println(solution.minScore(4, roads));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minScore(int n, int[][] roads) {
            List<int[]>[] adjacents = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                adjacents[i] = new ArrayList<>();
            }

            for (int[] road : roads) {
                adjacents[road[0]].add(new int[]{road[1], road[2]});
                adjacents[road[1]].add(new int[]{road[0], road[2]});
            }

            boolean[] visited = new boolean[n + 1];

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            int min = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int city = q.poll();
                visited[city] = true;
                for (int[] adjacent : adjacents[city]) {
                    if (!visited[adjacent[0]]) {
                        q.offer(adjacent[0]);
                        min = Math.min(min, adjacent[1]);
                    }
                }
            }

            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
