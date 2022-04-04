package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
    public static void main(String[] args) {
        System.out.println(new MaximumScoreFromRemovingStones().maximumScore(4, 4, 6));
    }

    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            first--;
            second--;
            ans++;
            if (first > 0) {
                pq.add(first);
            }
            if (second > 0) {
                pq.add(second);
            }
        }

        return ans;
    }
}
