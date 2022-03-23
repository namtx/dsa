package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/broken-calculator/
 */
public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        if (target <= startValue) return startValue - target;
        int count = 0;
        while (target != startValue) {
            if (target < startValue) return count + (startValue - target);
            if (target % 2 == 0) {
                target /= 2;
                count++;
            } else {
                target += 1;
                target /= 2;
                count += 2;
            }
        }
        return count;
    }
}
