package dev.namtx.leetcode.contest;

public class NodeWithHighestEdgeScores {
    public int edgeScore(int[] edges) {
        int[] scores = new int[edges.length];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (scores[i] > max) {
                ans = i;
                max = scores[i];
            }
        }

        return ans;
    }
}
