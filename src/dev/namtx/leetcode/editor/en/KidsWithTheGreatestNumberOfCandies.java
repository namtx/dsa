package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        Solution solution = new KidsWithTheGreatestNumberOfCandies().new Solution();
        System.out.println(solution.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = Integer.MIN_VALUE;
            for (int candy : candies) {
                max = Math.max(max, candy);
            }

            List<Boolean> ans = new ArrayList<>();
            for (int candy : candies) {
                if (candy + extraCandies >= max) {
                    ans.add(true);
                } else {
                    ans.add(false);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
