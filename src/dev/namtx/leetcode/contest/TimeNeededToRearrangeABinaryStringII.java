package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string
 */
public class TimeNeededToRearrangeABinaryStringII {
    public int secondsToRemoveOccurrences(String s) {
        int lastOneIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                lastOneIndex = i;
                break;
            }
        }
        if (lastOneIndex <= 0) return 0; // `1000000...000` already, so we don't need to rearrange anymore.

        int zeroes = 0;
        int waitingTime = 0;
        for (int i = 0; i <= lastOneIndex; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
                if (i > 0 && s.charAt(i - 1) == '0' && waitingTime > 0) {
                    waitingTime--;
                }
            } else {
                if (i > 0 && s.charAt(i - 1) == '1' && zeroes > 0) { // if number of zeroes is 0, we don't need to wait
                    waitingTime++;
                }
            }
        }

        return zeroes + waitingTime;
    }
}
