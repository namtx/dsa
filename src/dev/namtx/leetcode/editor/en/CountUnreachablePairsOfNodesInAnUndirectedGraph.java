package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};

        Solution solution = new CountUnreachablePairsOfNodesInAnUndirectedGraph().new Solution();

        System.out.println(solution.countPairs(7, edges));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }


        boolean[] visited = new boolean[n];
        long sum = n;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long count = bfs(i, visited, adjacent);
                sum -= count;
                ans += (count * sum);
            }
        }
        return ans;
    }

    private long bfs(int start, boolean[] visited, List<List<Integer>> adjacent) {
        Queue<Integer> q = new LinkedList<>();
        long count = 0;
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int adj: adjacent.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.offer(adj);
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
