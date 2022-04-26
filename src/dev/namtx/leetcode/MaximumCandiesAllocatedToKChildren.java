package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int candy: candies) {
            maxHeap.add(candy);
            min = Math.min(min, candy);
        }

        while(maxHeap.size() < k) {
            int max = maxHeap.poll();
            if (max == 1) return 0;
            if (max % 2 != 0) {
                maxHeap.add(1);
            }
            min = Math.min(min, max / 2);
            maxHeap.add(max / 2);
            maxHeap.add(max / 2);
        }

        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            tree.add(maxHeap.poll());
        }

        while(tree.first() <= tree.last()/2) {
            tree.remove(tree.first());
            int last = tree.last();
            tree.remove(last);
            if (last % 2 != 0) {
                tree.add(last/2+1);
            }
            tree.add(last/2);
        }

        return tree.first();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumCandiesAllocatedToKChildren().maximumCandies(new int[]{1,2,3,4,10}, 5));
    }
}
