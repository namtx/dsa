package dev.namtx.leetcode;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> inverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (inverseMap.containsKey(t.charAt(i))) {
                    if (inverseMap.get(t.charAt(i)) != s.charAt(i)) return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    inverseMap.put(t.charAt(i), s.charAt(i));
                }
            }
        }

        return true;
    }
}
