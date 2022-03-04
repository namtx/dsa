package dev.namtx.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/is-subsequence/
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                List<Integer> l = new java.util.ArrayList<>();
                l.add(i);
                map.put(c, l);
            } else {
                map.get(c).add(i);
            }
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) return false;

            List<Integer> l = map.get(c);
            int index = Collections.binarySearch(l, prev);
            if (index < 0) index = -index - 1;
            if (index == l.size()) return false;
            prev = l.get(index) + 1;
        }

        return true;
    }
}
