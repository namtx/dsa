package dev.namtx.leetcode.contest;

public class NumberOfSubarraysWithGCDEqualToK {
    public static void main(String[] args) {
        System.out.println(new NumberOfSubarraysWithGCDEqualToK().subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
    }

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            for (int j = i; j < nums.length; j++) {
                g = gcd(g, nums[j]);
                if (g == k) {
                    ans++;
                } else if (g < k) {
                    break;
                }
            }
        }

        return ans;
    }


    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
