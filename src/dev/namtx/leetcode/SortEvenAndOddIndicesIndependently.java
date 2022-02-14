package dev.namtx.leetcode;

import java.util.Arrays;

public class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        int[] evens;
        int[] odds;

        if (nums.length % 2 == 0) {
            evens = new int[nums.length/2];
        } else {
            evens = new int[nums.length/2+1];
        }
        odds =new int[nums.length/2];

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens[j] = nums[i];
            } else {
                odds[j++] = nums[i];
            }
        }

        Arrays.sort(evens);
        Arrays.sort(odds);

        int[] result = new int[nums.length];

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = evens[j];
            } else {
                result[i] = odds[odds.length-1-j++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortEvenAndOddIndicesIndependently().sortEvenOdd(new int[]{2})));
    }
}
