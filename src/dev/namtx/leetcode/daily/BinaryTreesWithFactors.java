package dev.namtx.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/binary-trees-with-factors/
 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        long[] dp = new long[arr.length];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], i);
        }
        Arrays.fill(dp, 1);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (m.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[m.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long x : dp) {
            ans += x;
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreesWithFactors().numFactoredBinaryTrees(new int[]{2,4,5,10}));
    }
}

