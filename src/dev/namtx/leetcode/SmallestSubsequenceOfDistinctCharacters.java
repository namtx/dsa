package dev.namtx.leetcode;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(new SmallestSubsequenceOfDistinctCharacters().smallestSubsequence("cbacdcbc"));
    }

    public String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (seen[c]) continue;
            seen[c] = true;
            while (!stack.isEmpty() && stack.peek() > c && last[stack.peek()] > i) {
                seen[stack.pop()] = false;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, (char) (stack.pop() + 'a'));
        }

        return sb.toString();
    }
}
