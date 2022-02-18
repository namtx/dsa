package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();

        helper(ans, s, new StringBuilder(), 0);

        return ans;
    }

    private void helper(List<String> ans, String s, StringBuilder sb, int index) {
        if (sb.length() == s.length()) {
            ans.add(sb.toString());
            return;
        }

        if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            helper(ans, s, sb.append(s.charAt(index)), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (Character.isUpperCase(s.charAt(index))) {
            helper(ans, s, sb.append(Character.toLowerCase(s.charAt(index))), index + 1);
            sb.deleteCharAt(sb.length() - 1);
            helper(ans, s, sb.append(s.charAt(index)), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            helper(ans, s, sb.append(Character.toUpperCase(s.charAt(index))), index + 1);
            sb.deleteCharAt(sb.length() - 1);
            helper(ans, s, sb.append(s.charAt(index)), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
