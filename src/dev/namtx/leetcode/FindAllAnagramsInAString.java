package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new FindAllAnagramsInAString().findAnagrams("aa", "bb"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new java.util.ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char c : p.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> ms = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0) + 1);
        }
        int i = p.length() - 1;
        while (i < s.length() - 1) {
            if (match(mp, ms)) {
                result.add(i - p.length() + 1);
            }
            i++;
            ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0) + 1);
            char key = s.charAt(i - p.length());
            ms.put(key, ms.getOrDefault(key, 0) - 1);
        }

        if (match(mp, ms)) {
            result.add(i - p.length() + 1);
        }

        return result;
    }

    private boolean match(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Character key : map1.keySet()) {
            if (map1.getOrDefault(key, 0) - map2.getOrDefault(key, 0) != 0) {
                return false;
            }
        }
        return true;
    }
}
