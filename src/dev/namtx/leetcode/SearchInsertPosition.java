package dev.namtx.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5}, 3));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] < target) {
            return nums.length;
        }
        if (nums[left] >= target) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (mid + 1 < nums.length && nums[mid + 1] > target) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
