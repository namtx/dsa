package dev.namtx.leetcode;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n]; // we use integer array to present a string
        Arrays.fill(chars, 'a'); // fill all characters by `a` (which has value 1)
        int remaining = k - n;
        int i = chars.length-1;
        while(remaining > 0) {
            if (remaining <= 26 - (chars[i] - 'a' + 1)) {
                chars[i] += remaining;
                break;
            } else {
                remaining -= (26 - (chars[i] - 'a' + 1));
                chars[i--] = 'z';
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithAGivenNumericValue().getSmallestString(95241, 2438640));
    }
}
