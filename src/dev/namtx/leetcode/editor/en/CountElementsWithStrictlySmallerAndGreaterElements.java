package dev.namtx.leetcode.editor.en;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    public static void main(String[] args) {
        Solution solution = new CountElementsWithStrictlySmallerAndGreaterElements().new Solution();
        System.out.println(solution.countElements(new int[]{11, 11, 7, 2, 2, 15, 15}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countElements(int[] nums) {
            if (nums.length <= 2) return 0;
            int min = nums[0];
            int max = nums[0];
            int minCount = 0;
            int maxCount = 0;

            for (int num : nums) {
                if (num < min) {
                    min = num;
                    minCount = 1;
                } else if (num == min) {
                    minCount++;
                }

                if (num > max) {
                    max = num;
                    maxCount = 1;
                } else if (num == max) {
                    maxCount++;
                }
            }

            if (max == min) return 0;

            return nums.length - minCount - maxCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
