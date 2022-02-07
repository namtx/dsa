package dev.namtx.leetcode;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] s_count = new int[26];
        int[] t_count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            s_count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            t_count[t.charAt(i) - 'a']++;
            if (t_count[t.charAt(i) - 'a'] > s_count[t.charAt(i) - 'a']) {
                return t.charAt(i);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("yy", "yyy"));
    }
}
