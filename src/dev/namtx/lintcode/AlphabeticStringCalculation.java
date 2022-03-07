package dev.namtx.lintcode;

import java.util.HashSet;
import java.util.Set;

public class AlphabeticStringCalculation {
    public int Kstart(String aString) {
        int count = 0;
        int[] alphabets = new int[26];
        for (char c : aString.toCharArray()) {
            alphabets[c - 'a']++;
        }

        Set<Integer> s = new HashSet();
        s.add(alphabets[0]);
        for (int i = 1; i < alphabets.length; i++) {
            while (alphabets[i] > 0 && s.contains(alphabets[i])) {
                alphabets[i]--;
                count++;
            }
            s.add(alphabets[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new AlphabeticStringCalculation().Kstart("aabcd"));
    }
}
