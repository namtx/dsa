package dev.namtx.leetcode.daily;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;


        while (n % 5 == 0) {
            n /= 5;
        }
        if (n == 1) return true;
        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) return true;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}