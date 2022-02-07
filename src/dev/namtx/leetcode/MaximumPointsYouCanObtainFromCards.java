package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards
 * <p>
 * tags: prefix-sum
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[][][] tests = {
                {{1, 2, 3, 4, 5, 6, 1}, {3}},
                {{2, 2, 2}, {2}},
                {{9, 7, 7, 9, 7, 7, 9}, {7}},
                {{96, 90, 41, 82, 39, 74, 64, 50, 30}, {8}},
        };

        for (int[][] test : tests) {
            System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(test[0], test[1][0]));
        }
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = cardPoints[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + cardPoints[i];
        }

        int max = 0;

        if (n == k) {
            return prefixSum[n - 1];
        }

        int windowSize = n - k;
        for (int i = 0; i <= n - windowSize; i++) {
            max = Math.max(max, prefixSum[n - 1] - (prefixSum[i + windowSize - 1] - (i == 0 ? 0 : prefixSum[i - 1])));
        }

        return max;
    }
}
