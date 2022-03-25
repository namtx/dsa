package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {
    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling().twoCitySchedCost(
                new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}}
        ));
    }

    public int twoCitySchedCost(int[][] costs) {
        int[][] costWithSavings = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            costWithSavings[i][0] = costs[i][0];
            costWithSavings[i][1] = costs[i][1];
            costWithSavings[i][2] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(costWithSavings, Comparator.comparingInt(o -> o[2]));
        int ans = 0;

        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                ans += costWithSavings[i][0];
            } else {
                ans += costWithSavings[i][1];
            }
        }

        return ans;
    }
}
