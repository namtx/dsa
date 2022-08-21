package dev.namtx.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-307/problems/largest-palindromic-number/
 * <br>
 * Input: 444947137
 * <br>
 * Output: 7449447
 */
public class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char digit : num.toCharArray()) {
            frequencies.put(digit, frequencies.getOrDefault(digit, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int offset = 0;
        for (Character c = '9'; c >= '0'; c--) {
            int count = frequencies.getOrDefault(c, 0);
            if (count > 1) {
                for (int i = 0; i < count / 2 * 2; i++) {
                    sb.insert(offset, c);
                }
                frequencies.put(c, count - count / 2 * 2);
                offset += count / 2;
            }
        }

        for (Character c = '9'; c >= '0'; c--) {
            int count = frequencies.getOrDefault(c, 0);
            if (count == 1) {
                sb.insert(offset, c);
                break;
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
