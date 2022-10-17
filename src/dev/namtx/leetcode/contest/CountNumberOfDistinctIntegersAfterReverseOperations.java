package dev.namtx.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-315/problems/count-number-of-distinct-integers-after-reverse-operations/
 */
public class CountNumberOfDistinctIntegersAfterReverseOperations {
    public static void main(String[] args) {
        System.out.println(new CountNumberOfDistinctIntegersAfterReverseOperations().countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) continue;
            set.add((long) num);
            set.add(reverse(num));
        }

        return set.size();
    }

    private long reverse(int num) {
        long r = 0;
        while (num > 0) {
            r *= 10;
            r += num % 10;
            num /= 10;
        }

        return r;
    }
}
