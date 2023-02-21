package dev.namtx.leetcode.editor.en;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{0,0,1,1,2,2,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (right - left > 2) {
                int middle = left + (right - left) / 2;
                if ((middle - left) % 2 == 0) {
                    // that means number of parts are even
                    // so if the middle element equals to the end of first part, then the seeking element is belongs to the first part
                    if (nums[middle] == nums[middle-1]) {
                        right = middle;
                    } else if (nums[middle] == nums[middle+1]) {
                        left = middle;
                    } else {
                        return nums[middle];
                    }
                } else {
                    // that means number of parts are odd
                    // so if the middle element equals to the end of first part, then the seeking element is belongs to the second part
                    if (nums[middle] == nums[middle-1]) {
                        left = middle+1;
                    } else if (nums[middle] == nums[middle+1]) {
                        right = middle-1;
                    } else {
                        return nums[middle];
                    }
                }
            }

            int middle = left + (right - left) / 2;
            if (nums[middle] == nums[left]) return nums[right];
            if (nums[middle] == nums[right]) return nums[left];
            return nums[middle];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
