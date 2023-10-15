package dev.namtx.leetcode.editor.en;

public class MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        Solution solution = new MaximumValueOfAnOrderedTripletI().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    long tripletValue = ((long) (nums[i] - nums[j])) * (long)nums[k];
                    if (tripletValue > max) {
                        max = tripletValue;
                    }
                }
            }
        }

        return Math.max(max, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
