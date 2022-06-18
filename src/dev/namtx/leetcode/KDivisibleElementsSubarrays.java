package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Set;

public class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new java.util.HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            getDivisibleSubarray(set, nums, k, p, i, i, 0);
        }
        System.out.println(set);
        return set.size();
    }
    
    private void getDivisibleSubarray(Set<String> set, int[] nums, int k, int p, int start, int i, int count) {
        if (i >= nums.length) {
            return;
        }
        if (nums[i] % p == 0) {
            count++;
            if (count > k) {
                return;
            }
        }
        String h = hash(Arrays.copyOfRange(nums, start, i + 1));
        set.add(h);
        getDivisibleSubarray(set, nums, k, p, start, i + 1, count);
    }

    private String hash(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
            sb.append("-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new KDivisibleElementsSubarrays().countDistinct(new int[]{1,9,8,7,19}, 1, 6));
    }
}
