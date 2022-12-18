package dev.namtx.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    public int similarPairs(String[] words) {
        int[][] buckets = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                buckets[i][c-'a']++;
            }
        }

        int[] hashes = new int[buckets.length];
        for (int i = 0; i < words.length; i++) {
            hashes[i] = hash(buckets[i]);
        }

        int ans = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (hashes[i] == hashes[j]) ans++;
            }
        }

        return ans;
    }

    private int hash(int[] bucket) {
        int ans = 1;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                ans = ans * primes[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountPairsOfSimilarStrings().similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));
    }
}
