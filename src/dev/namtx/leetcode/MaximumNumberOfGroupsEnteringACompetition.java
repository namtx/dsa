package dev.namtx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition
 */
public class MaximumNumberOfGroupsEnteringACompetition {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfGroupsEnteringACompetition().maximumGroups(new int[]{3, 5, 6, 7, 10}));
    }

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);

        int ans = 0;
        int groupSize = 0;
        int i = 0;
        while (i + groupSize < grades.length) {
            groupSize++;
            i += groupSize;
            ans++;
        }

        return ans;
    }
}
