package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {
    public static void main(String[] args) {
        System.out.println(new MinimumAmountOfTimeToFillCups().fillCups(new int[]{1, 2, 4}));
    }

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int c : amount) {
            if (c > 0) {
                pq.add(c);
            }
        }

        int ans = 0;
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            ans++;
            if (first > 1) {
                pq.add(first - 1);
            }
            if (second > 1) {
                pq.add(second - 1);
            }
        }

        if (!pq.isEmpty()) {
            ans += pq.peek();
        }

        return ans;
    }
}
