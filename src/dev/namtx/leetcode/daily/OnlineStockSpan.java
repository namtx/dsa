package dev.namtx.leetcode.daily;

import java.util.Stack;

public class OnlineStockSpan {
    static class StockSpanner {
        Stack<int[]> stack = new Stack<>();

        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                ans += stack.pop()[1];
            }
            stack.push(new int[]{price, ans});
            return ans;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.println(stockSpanner.next(price));
        }
    }
}
