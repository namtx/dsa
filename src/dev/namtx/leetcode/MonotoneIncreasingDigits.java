package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(798));
    }

    public int monotoneIncreasingDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int i = 0;
        while (i < digits.size() - 1) {
            if (digits.get(i) >= digits.get(i + 1)) {
                i++;
            } else {
                for (int j = 0; j <= i; j++) {
                    digits.set(j, 9);
                }
                digits.set(i + 1, digits.get(i + 1) - 1);
            }
        }
        int ans = 0;
        for (int k = digits.size() - 1; k >= 0; k--) {
            ans = ans * 10 + digits.get(k);
        }

        return ans;
    }
}
