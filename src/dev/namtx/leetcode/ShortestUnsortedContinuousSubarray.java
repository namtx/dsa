package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * <p>
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int gap = right - left + 1;
        while (left <= right) {
            if (nums[right] >= nums[left]) {
                if (nums[left] <= nums[left + 1]) left++;
                if (nums[right] >= nums[right - 1]) right--;
                if (right - left + 1 == gap) {
                    return right - left + 1;
                } else {
                    gap = right - left + 1;
                }
            } else {
                int oldLeft = left;
                int oldRight = right;
                while(right < nums.length-1 && nums[right] < nums[oldLeft]) {
                    right++;
                }
                while(left > 0 && nums[left] > nums[oldRight]) {
                    left--;
                }
                return Math.min(right-oldLeft+1, oldRight-left);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1,3,2,4,5}));
    }
}
