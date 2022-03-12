package dev.namtx.leetcode;

import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString solution = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(solution.removeDuplicates("abaccccddddd"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
