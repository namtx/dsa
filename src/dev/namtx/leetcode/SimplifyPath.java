package dev.namtx.leetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] groups = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String group: groups) {
            if (group.length() == 0 || group.equals(".")) {
            } else if (group.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(group);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }

        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
    }
}
