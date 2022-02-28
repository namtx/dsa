package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        System.out.println(new FindAndReplacePattern().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new java.util.ArrayList<>();

        for (String word : words) {
            if (match(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean match(String s, String p) {
        Map<Character, Character> m = new HashMap<>();
        Map<Character, Boolean> mapped = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if (m.containsKey(p.charAt(i))) {
                if (m.get(p.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                if (mapped.containsKey(s.charAt(i))) return false;
                m.put(p.charAt(i), s.charAt(i));
                mapped.put(s.charAt(i), true);
            }
        }

        return true;
    }
}
