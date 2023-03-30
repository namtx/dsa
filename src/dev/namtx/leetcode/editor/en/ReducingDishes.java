package dev.namtx.leetcode.editor.en;

import java.util.Arrays;

public class ReducingDishes {
    public static void main(String[] args) {
        Solution solution = new ReducingDishes().new Solution();
        System.out.println(solution.maxSatisfaction(new int[]{4, 3, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            int n = satisfaction.length;
            Arrays.sort(satisfaction);
            for (int i = 0; i < n / 2; i++) {
                int tmp = satisfaction[i];
                satisfaction[i] = satisfaction[n - i - 1];
                satisfaction[n - i - 1] = tmp;
            }
            int prefixSum = 0;
            int ans = 0;

            for (int i = 0; i < satisfaction.length; i++) {
                prefixSum += satisfaction[i];
                if (prefixSum >= 0) {
                    ans += prefixSum;
                } else {
                    break;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
