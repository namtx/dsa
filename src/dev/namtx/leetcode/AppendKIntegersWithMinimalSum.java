package dev.namtx.leetcode;

import java.util.TreeSet;

public class AppendKIntegersWithMinimalSum {
    public static void main(String[] args) {
        System.out.println(new AppendKIntegersWithMinimalSum().minimalKSum(
                new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84},
                35
        ));
    }

    public long minimalKSum(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] arr = new int[set.size()];
        int z = 0;
        for (int num : set) {
            arr[z++] = num;
        }
        long left = 1;
        int i = 0;
        long sum = 0;
        while (k > 0) {
            long range = arr[i] - left;
            if (range > 0) {
                if (range > k) {
                    sum += (k) * (2 * left + k - 1) / 2;
                    return sum;
                } else {
                    sum += (range) * (2 * left + range - 1) / 2;
                    k -= range;
                }
            }
            left = arr[i] + 1;
            i++;
            if (i >= arr.length) {
                sum += (k) * (2 * left + k - 1) / 2;
                return sum;
            }
        }

        return sum;
    }
}
