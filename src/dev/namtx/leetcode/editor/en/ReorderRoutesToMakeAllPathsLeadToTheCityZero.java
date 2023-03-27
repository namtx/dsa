package dev.namtx.leetcode.editor.en;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        Solution solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();
        System.out.println(solution.minReorder(5, new int[][]{{4,3},{2,3},{1,2},{1,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class UnionFind {
        int[] parent;

        UnionFind(int size, int[][] connections) {
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int a) {
            if (parent[a] == a) return a;
            parent[a] = find(parent[a]);
            return parent[a];
        }

        boolean union(int a, int b) {
            int setA = find(a);
            int setB = find(b);
            if (setA == 0 && setB == 0) return true;
            if (setA == 0) {
                parent[setB] = 0;
                return false;
            } else parent[setA] = setB;
            return true;
        }
    }

    class Solution {
        public int minReorder(int n, int[][] connections) {
            UnionFind unionFind = new UnionFind(n, connections);
            int ans = 0;
            for (int[] connection : connections) {
                if (!unionFind.union(connection[0], connection[1])) {
                    ans++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (unionFind.find(i) != 0) ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
