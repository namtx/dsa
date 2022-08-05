package dev.namtx.leetcode;

import java.util.HashMap;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        HashMap<Character, Boolean> m = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (m.containsKey(c)) {
                return c;
            } else {
                m.put(c, true);
            }
        }

        return 'a';
    }
}
