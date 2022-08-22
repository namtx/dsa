package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/slowest-key/
 */
public class LowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestDuration = Integer.MIN_VALUE;
        char lowestChar = keysPressed.charAt(0);
        for (int i = 0; i < keysPressed.length(); i++) {
            int time = (i == 0) ? releaseTimes[0] : releaseTimes[i] - releaseTimes[i - 1];
            if (time > longestDuration) {
                longestDuration = time;
                lowestChar = keysPressed.charAt(i);
            } else if (time == longestDuration && keysPressed.charAt(i) > lowestChar) {
                lowestChar = keysPressed.charAt(i);
            }
        }

        return lowestChar;
    }
}
