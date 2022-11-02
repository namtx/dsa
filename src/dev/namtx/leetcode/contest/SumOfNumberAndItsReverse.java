package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/problems/sum-of-number-and-its-reverse/
 */
public class SumOfNumberAndItsReverse {
    public static void main(String[] args) {
        System.out.println(new SumOfNumberAndItsReverse().sumOfNumberAndReverse(181));
    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num - 1; i >= 1; i--) {
            int r = reverse(i);
            if (i + r == num) {
                System.out.printf("Found %d + %d = %d\n", i, r, num);
                return true;
            }
        }

        return false;
    }

    private int reverse(int num) {
        int r = 0;
        while (num > 0) {
            r *= 10;
            r += num % 10;
            num /= 10;
        }

        return r;
    }
}
