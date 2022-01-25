package dev.namtx.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * <p>
 * tags: stack, string
 */
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new Pair(c, sb.length()));
                sb.append(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            sb.deleteCharAt(p.pos);
        }

        return sb.toString();
    }

    static class Pair {
        char c;
        int pos;

        public Pair(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }
}
