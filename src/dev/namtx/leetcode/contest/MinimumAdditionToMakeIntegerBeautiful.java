package dev.namtx.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-317/problems/minimum-addition-to-make-integer-beautiful/
 */
public class MinimumAdditionToMakeIntegerBeautiful {
    public static void main(String[] args) {
        System.out.println(new MinimumAdditionToMakeIntegerBeautiful().makeIntegerBeautiful(94590, 6));
    }

    public long makeIntegerBeautiful(long n, int target) {
        List<Integer> digits = new ArrayList<>();
        int digitSum = 0;
        while (n > 0) {
            int odd = (int) (n % 10);
            digitSum += odd;
            digits.add(odd);
            n /= 10;
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (digitSum > target) {
            if (digits.get(i) == 0) {
                ans.add(0);
                i++;
                continue;
            }
            int j = i + 1;
            int addition = 1;
            digitSum -= digits.get(i);
            ans.add(10 - digits.get(i));
            digits.set(i, 0);
            while (addition != 0 && j < digits.size()) {
                int newValue = digits.get(j) + addition;
                if (newValue >= 10) {
                    digitSum -= digits.get(j);
                }
                digits.set(j, newValue % 10);
                addition = (newValue / 10);
                j++;
            }
            if (addition > 0) {
                digits.add(addition);
            }
            digitSum++;
            i++;
        }
        long r = 0;
        for (int k = ans.size() - 1; k >= 0; k--) {
            r = r * 10 + ans.get(k);
        }

        return r;
    }
}
