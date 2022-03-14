package dev.namtx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while(n > 0) {
                sum += (n%10) * (n%10);
                n /= 10;
            }
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
