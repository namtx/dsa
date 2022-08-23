package dev.namtx.leetcode.daily;

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii
 */
public class MinimumSwapsToGroupAllOnesTogetherII {
    public int minSwaps(int[] nums) {
        int[] concated = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            concated[i] = nums[i];
            concated[i + nums.length] = nums[i];
        }
        int windowSize = 0;
        for (int num : nums) {
            if (num == 1) {
                windowSize++;
            }
        }

        int zeroes = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                zeroes++;
            }
        }
        int ans = zeroes;
        for (int i = 1; i < nums.length; i++) {
            if (concated[i - 1] == 0) {
                zeroes--;
            }
            if (concated[i + windowSize - 1] == 0) {
                zeroes++;
            }
            ans = Math.min(zeroes, ans);
        }

        return ans;
    }
}
