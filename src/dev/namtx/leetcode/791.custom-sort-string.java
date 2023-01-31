package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start

class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> rank = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            rank.put(order.charAt(i), i + 1);
        }
        Map<Integer, List<Character>> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (rank.containsKey(s.charAt(i))) {
                List<Character> l = m.getOrDefault(rank.get(c), new ArrayList<>());
                l.add(c);
                m.put(rank.get(c), l);
            } else {
                List<Character> l = m.getOrDefault(0, new ArrayList<>());
                l.add(c);
                m.put(0, l);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < order.length() + 1; i++) {
            for (char c : m.getOrDefault(i, new ArrayList<>())) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
// @lc code=end
