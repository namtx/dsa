package dev.namtx.leetcode.editor.en;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
        Solution solution = new EliminateMaximumNumberOfMonsters().new Solution();
        System.out.println(solution.eliminateMaximum(new int[]{46,33,44,42,46,36,7,36,31,47,38,42,43,48,48,25,28,44,49,47,29,32,30,6,42,9,39,48,22,26,50,34,40,22,10,45,7,43,24,18,40,44,17,39,36}, new int[]{1,2,1,3,1,1,1,1,1,1,1,1,1,1,7,1,1,3,2,2,2,1,2,1,1,1,1,1,1,1,1,6,1,1,1,8,1,1,1,3,6,1,3,1,1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] estTime = new double[dist.length];
        for(int i = 0; i < dist.length; i++) {
            estTime[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(estTime);

        for (int i = 0; i < dist.length; i++) {
            if (estTime[i] <= i) return i;
        }

        return dist.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
