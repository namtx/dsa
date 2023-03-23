package dev.namtx.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Solution solution = new NumberOfOperationsToMakeNetworkConnected().new Solution();
        System.out.println(solution.makeConnected(6, new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
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
            if (setA == setB) {
                return false;
            }
            if (a < b) {
                parent[setB] = setA;
            } else {
                parent[setA] = setB;
            }
            return true;
        }
    }

    class Solution {
        public int makeConnected(int n, int[][] connections) {
            int redundantCables = 0;
            UnionFind unionFind = new UnionFind(n);
            for (int[] connection : connections) {
                if (!unionFind.union(connection[0], connection[1])) {
                    redundantCables++;
                }
            }

            Set<Integer> parents = new HashSet<>();
            for (int i = 0; i < n; i++) {
                parents.add(unionFind.find(i));
            }
            int neededCables = parents.size() - 1;

            if (neededCables > redundantCables) return -1;
            return neededCables;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
