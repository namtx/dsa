package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
        )));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            int l = Math.max(firstList[i][0], secondList[j][0]);
            if (l <= hi) {
                ans.add(new int[]{l, hi});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
