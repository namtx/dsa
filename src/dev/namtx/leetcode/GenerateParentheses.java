package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            helper(result, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            sb.append(')');
            helper(result, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
