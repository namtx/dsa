package dev.namtx.leetcode.daily;

public class MinimumAverageDifference {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 9, 5, 3};
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(nums));
    }

    public int minimumAverageDifference(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int firstAverage = prefixSum[i] / (i + 1);
            int lastAverage = (prefixSum[nums.length - 1] - prefixSum[i]) / (nums.length - i - 1);
            System.out.println(Math.abs(firstAverage - lastAverage));
            if (min > Math.abs(firstAverage - lastAverage)) {
                min = Math.abs(firstAverage - lastAverage);

                ans = i;
            }
        }

        if (min > prefixSum[nums.length - 1] / nums.length) {
            return nums.length - 1;
        }

        return ans;
    }
}
