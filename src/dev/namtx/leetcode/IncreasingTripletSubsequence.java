package dev.namtx.leetcode;

import java.util.Stack;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            if (stack.isEmpty() || num > stack.peek()) {
                stack.push(num);
            }
            if (stack.size() >= 3) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{6,7,1,2}));
    }
}
