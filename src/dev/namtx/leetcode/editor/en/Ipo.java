package dev.namtx.leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();
        System.out.println(solution.findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(capital[i], profits[i]);
            }
            Arrays.sort(pairs);
            int currentCapital = w;

            PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (o2.profit) - (o1.profit));
            int j = 0;
            for (int i = 0; i < k; i++) {
                while (j < n && pairs[j].capital <= currentCapital) {
                    pq.add(pairs[j]);
                    j++;
                }
                if (pq.isEmpty()) return currentCapital;
                Pair picked = pq.poll();
                currentCapital += picked.profit;
            }

            return currentCapital;
        }

        class Pair implements Comparable<Pair> {
            int capital;
            int profit;

            public Pair(int capital, int profit) {
                this.capital = capital;
                this.profit = profit;
            }

            @Override
            public int compareTo(Pair p) {
                return capital - p.capital;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
