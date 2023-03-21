package dev.namtx.leetcode.editor.en;

public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        Solution solution = new NumberOfZeroFilledSubarrays().new Solution();
        System.out.println(solution.zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long ans = 0;
            long count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    ans += count * (count + 1) / 2;
                    count = 0;
                }
            }
            if (count != 0) {
                ans += count * (count + 1) / 2;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
