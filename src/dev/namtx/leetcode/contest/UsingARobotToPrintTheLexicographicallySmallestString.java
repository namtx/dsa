package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/contest/weekly-contest-314/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {
    // TODO: Fix
    public static void main(String[] args) {
        String s = "bac";

        System.out.println(new UsingARobotToPrintTheLexicographicallySmallestString().robotWithString(s));
    }

    public String robotWithString(String s) {
        StringBuilder t = new StringBuilder();
        StringBuilder p = new StringBuilder();
        char[] suffixMinimum = new char[s.length()];
        char min = s.charAt(s.length() - 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) <= min) {
                min = s.charAt(i);
            }
            suffixMinimum[i] = min;
        }

        int j = 0;
        while (j < s.length()) {
            if (t.length() == 0) {
                if (suffixMinimum[j] == s.charAt(j)) {
                    p.append(s.charAt(j));
                } else {
                    t.append(s.charAt(j));
                }
                j++;
            } else {
                if (t.charAt(t.length() - 1) <= suffixMinimum[j]) {
                    p.append(t.charAt(t.length() - 1));
                    t = t.deleteCharAt(t.length() - 1);
                } else {
                    t.append(s.charAt(j));
                    j++;
                }
            }
        }
        p.append(t.reverse());

        return p.toString();
    }
}
