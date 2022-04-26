package dev.namtx.leetcode;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                if (nums[right] >= nums[right - 1]) {
                    right--;
                } else {
                    return nums[right];
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(
                new FindMinimumInRotatedSortedArrayII().findMin(new int[] {1,1,1,1,2,1,1})
        );
    }
}
