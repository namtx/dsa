package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/2-keys-keyboard
 */
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(1));
    }

    public int minSteps(int n) {
        int steps = 0;
        int copyLength = 0;
        int strLength = 1;
        int remaining = n;

        if (n == 1) return 0;

        while (remaining > 0) {
            if (remaining % strLength == 0) {
                copyLength = strLength;
                strLength += copyLength;
                steps += 2; // Copy All and Paste
            } else {
                strLength += copyLength;
                steps++; // Paste only
            }
            remaining = n - strLength;
        }

        return steps;
    }
}
