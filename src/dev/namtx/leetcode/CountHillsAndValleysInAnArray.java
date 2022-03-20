package dev.namtx.leetcode;

public class CountHillsAndValleysInAnArray {
    public static void main(String[] args) {
        System.out.println(new CountHillsAndValleysInAnArray().countHillValley(new int[]{6,6, 5, 4}));
    }

    public int countHillValley(int[] nums) {
        int trend = 0; // initiated by 0, 1 means increasing, -1 mean decreasing
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) { // decreasing
                if (trend == 1) {
                    ans++;
                }
                trend = -1;
            } else if (nums[i] > nums[i - 1]) { // increasing
                if (trend == -1) {
                    ans++;
                }
                trend = 1;
            }
        }

        return ans;
    }
}
