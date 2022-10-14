package dev.namtx.leetcode.contest;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-314/problems/find-the-original-array-of-prefix-xor/
 */
public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[] pref = new int[]{5, 2, 0, 3, 1};

        System.out.println(Arrays.toString(new FindTheOriginalArrayOfPrefixXor().findArray(pref)));
    }

    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < ans.length; i++) {
            ans[i] = pref[i - 1] ^ pref[i];
        }

        return ans;
    }
}
