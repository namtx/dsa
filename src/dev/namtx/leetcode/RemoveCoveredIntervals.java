package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {3, 6}, {2, 8}};
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int left = -1;
        int right = -1;
        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] > right) {
                left = interval[0];
                ans++;
            }
            right = Math.max(right, interval[1]);
        }

        return ans;
    }
}
