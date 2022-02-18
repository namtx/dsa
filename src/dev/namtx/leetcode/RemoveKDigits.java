package dev.namtx.leetcode;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("10200", 1));
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i) - '0') {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i) - '0');
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
