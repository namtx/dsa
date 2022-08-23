package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/problems/shifting-letters-ii
 */
public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] moves = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int offset = shift[2] == 1 ? 1 : -1;
            moves[shift[0]] += offset;
            moves[shift[1] + 1] -= offset;
        }

        int prefixSum = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixSum += moves[i];
            int newChar = ((chars[i] - 'a') + prefixSum) % 26;
            if (newChar < 0) {
                newChar += 26;
            }
            chars[i] = (char) ('a' + newChar);
        }

        return String.valueOf(chars);
    }
}
