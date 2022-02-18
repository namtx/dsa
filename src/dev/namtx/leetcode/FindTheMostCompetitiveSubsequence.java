package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindTheMostCompetitiveSubsequence().mostCompetitive(new int[]{4, 3, 1, 2, 5, 6, 7}, 4)));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length - k;

        int i = 0;
        while (i < nums.length) {
            while (n > 0 && !stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
                n--;
            }
            stack.push(nums[i]);
            i++;
        }
        while (stack.size() > k) {
            stack.pop();
        }

        int[] res = new int[k];
        i = k - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}
