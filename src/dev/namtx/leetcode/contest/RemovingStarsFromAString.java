package dev.namtx.leetcode.contest;

import java.util.Stack;

/**
 * https://leetcode.com/contest/weekly-contest-308/problems/removing-stars-from-a-string/
 */
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
