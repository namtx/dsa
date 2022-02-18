package dev.namtx.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int right = nums.length - 1;
        while (right >= 1 && nums[right] <= nums[right - 1]) right--;
        if (right == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int k = nums.length - 1;
        while (k > right && nums[k] <= nums[right - 1]) k--;
        swap(nums, k, right - 1);
        reverse(nums, right, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
