package dev.namtx.leetcode.daily;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(new MakeTheStringGreat().makeGood("leEeetcode"));
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.size() == 0) {
                stack.push(c);
            } else {
                char p = stack.peek();
                if (p != c && Math.abs(p - c) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
