package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string
 */
public class TimeNeededToRearrangeABinaryString {
    public int secondsToRemoveOccurrences(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '0' && chars[i + 1] == '1') {
                    // swap
                    char tmp = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = tmp;
                    changed = true;
                    i++;
                }
            }
            if (changed) ans++;
        }

        return ans;
    }
}
