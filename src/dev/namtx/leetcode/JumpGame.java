package dev.namtx.leetcode;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[nums.length];

        dp[N - 1] = true;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 1; i + j < N && j <= nums[i]; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
