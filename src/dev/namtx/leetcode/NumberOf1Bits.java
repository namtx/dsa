package dev.namtx.leetcode;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(11));
    }
}
