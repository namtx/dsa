package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> mappings = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        mappings.put('2', Arrays.asList('a', 'b', 'c'));
        mappings.put('3', Arrays.asList('d', 'e', 'f'));
        mappings.put('4', Arrays.asList('g', 'h', 'i'));
        mappings.put('5', Arrays.asList('j', 'k', 'l'));
        mappings.put('6', Arrays.asList('m', 'n', 'o'));
        mappings.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mappings.put('8', Arrays.asList('t', 'u', 'v'));
        mappings.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        helper(ans, new StringBuilder(), mappings, digits, 0);

        return ans;
    }

    private void helper(List<String> result, StringBuilder sb, HashMap<Character, List<Character>> mappings, String digits, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (Character c : mappings.get(digits.charAt(index))) {
            sb.append(c);
            helper(result, sb, mappings, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
