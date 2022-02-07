package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[][] testCases = {
                {7, 1, 5, 3, 6, 4},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {1, 2, 1, 0},
                {1}
        };

        for (int[] testCase : testCases) {
            System.out.println(new BestTimeToBuyAndSellStock().maxProfit(testCase));
        }
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
