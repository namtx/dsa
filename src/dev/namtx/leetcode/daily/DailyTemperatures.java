package dev.namtx.leetcode.daily;

import java.util.Arrays;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int hottest = 0;

        for (int i = temperatures.length-1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                ans[i] = 0;
                hottest = temperatures[i];
            } else {
                int days = 1;
                while(temperatures[i+days] <= temperatures[i]) {
                    days += ans[i+days];
                }

                ans[i] = days;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})));
    }
}
