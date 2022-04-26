package dev.namtx.leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{2, 2, 3, 4}));
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
