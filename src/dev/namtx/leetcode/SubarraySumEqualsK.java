package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1,1,1,1,2,3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int count = 0;
        m.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int find = sum - k;
            if (m.containsKey(find)) {
                count += m.get(find);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
