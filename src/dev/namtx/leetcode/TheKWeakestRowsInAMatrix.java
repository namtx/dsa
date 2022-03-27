package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(mat.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int count = 0;
            for (int cell: row)
                if (cell == 1) count++;
            queue.add(new int[]{i, count});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int[] row = queue.poll();
            ans[i] = row[0];
        }

        return ans;
    }
}
