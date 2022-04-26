package dev.namtx.leetcode;

public class MinimumDeletionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int offset = 0;
        int ans = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                if ((i + offset) % 2 == 0) {
                    offset = offset ^ 1;
                    ans++;
                }
            }
        }

        if ((nums.length + offset) % 2 != 0) ans++;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{1,1,2,2,3,3}));
    }
}
