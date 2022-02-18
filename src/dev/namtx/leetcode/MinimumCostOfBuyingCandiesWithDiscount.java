package dev.namtx.leetcode;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        System.out.println(new MinimumCostOfBuyingCandiesWithDiscount().minimumCost(new int[]{5, 5}));
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int i = cost.length;
        while (i - 2 >= 0) {
            sum += cost[i - 1] + cost[i - 2];
            i -= 3;
        }
        while (i > 0) {
            sum += cost[i--];
        }

        return sum;
    }
}
