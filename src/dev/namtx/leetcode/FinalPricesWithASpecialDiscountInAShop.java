package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * <p>
 * tags: monotonic stack
 * [8,4,6,2,3]
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new FinalPricesWithASpecialDiscountInAShop()
                                .finalPrices(new int[]{10, 1, 1, 6})
                )
        );
    }

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();

            stack.push(prices[i]);
        }

        return ans;
    }
}
