package dev.namtx.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * <p>
 * tags: monotonic stack
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ans;
    }
}
