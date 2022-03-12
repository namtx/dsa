package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmallestValueOfTheRearrangedNumber {
    public static void main(String[] args) {
        System.out.println(new SmallestValueOfTheRearrangedNumber().smallestNumber(123415151));
    }

    public long smallestNumber(long num) {
        if (num == 0) return 0;
        List<Integer> digits = new ArrayList<>();
        int sign = num < 0 ? -1 : 1;
        if (num < 0) num *= -1;
        while (num > 0) {
            digits.add((int) (num % 10));
            num /= 10;
        }
        if (sign == -1) {
            digits.sort((a, b) -> b - a);
        } else {
            digits.sort(Comparator.comparingInt(a -> a));

            if (digits.get(0) == 0) {
                int i = 0;
                while (i < digits.size() && digits.get(i) == 0) {
                    i++;
                }
                int tmp = digits.get(i);
                digits.set(i, digits.get(0));
                digits.set(0, tmp);
            }
        }

        long result = 0;
        for (Integer digit : digits) {
            result = result * 10 + digit;
        }

        return result * sign;
    }
}
