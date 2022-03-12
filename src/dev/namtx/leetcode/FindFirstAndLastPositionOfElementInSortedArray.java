package dev.namtx.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new FindFirstAndLastPositionOfElementInSortedArray()
                                .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)
                )
        );
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int leftIndex = mid;
                int rightIndex = mid;
                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    leftIndex--;
                }
                while (rightIndex < nums.length && nums[rightIndex] == target) {
                    rightIndex++;
                }

                return new int[]{leftIndex + 1, rightIndex - 1};
            }
        }

        return new int[]{-1, -1};

    }
}
