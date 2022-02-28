package dev.namtx.leetcode;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6, 3, 6, 3, 2}, 100));
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{1000}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int i = 0;
        int product = 1;
        int count = 0;
        while (i < nums.length) {
            product *= nums[i];
            while (product >= k && start <= i) {
                product /= nums[start++];
            }
            if (start > nums.length) {
                return count;
            }
            count += i - start + 1;
            i++;
        }

        return count;
    }
}
