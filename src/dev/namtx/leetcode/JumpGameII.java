package dev.namtx.leetcode;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int N = nums.length;
        int farthest = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                count++;
                end = farthest;
            }
        }

        return count;
    }
}
