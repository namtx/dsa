package dev.namtx.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();

        for (Character c: s.toCharArray()) {
            if (!isOpen(c)) {
                if (stack.isEmpty()) return false;
                if (!isPair(stack.peek(), c)) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(Character open, Character close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    private boolean isOpen(Character open) {
        return open == '(' || open == '[' || open == '{';
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()("));
    }
}
