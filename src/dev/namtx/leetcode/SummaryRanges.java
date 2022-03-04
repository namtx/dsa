package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            while (end < nums.length - 1 && nums[end] + 1 == nums[end + 1]) {
                end++;
            }
            if (start == end) {
                ans.add(String.valueOf(nums[start]));
            } else {
                ans.add(String.format("%d->%d", nums[start], nums[end]));
            }
            end++;
            start = end;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{1}));
    }
}
