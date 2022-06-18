package dev.namtx.leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInStringII().removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Item> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(new Item(c, 1));
            } else {
                Item top = stack.peek();
                if (c == top.c) {
                    if (top.streak == k - 1) {
                        for (int i = 0; i < k - 1; i++) {
                            stack.pop();
                        }
                    } else {
                        stack.push(new Item(c, top.streak + 1));
                    }
                } else {
                    stack.add(new Item(c, 1));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop().c);
        }
        return res.toString();
    }

    static class Item {
        int streak;
        char c;

        Item(char c, int streak) {
            this.c = c;
            this.streak = streak;
        }
    }
}
