package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> evens = new HashMap<>();
        Map<Integer, Integer> odds = new HashMap<>();
        int evenCount;
        if (nums.length % 2 == 0) {
            evenCount = nums.length / 2 + 1;
        } else {
            evenCount = nums.length / 2;
        }
        int oddCount = nums.length - evenCount;

        for (int num : nums) {
            if (num % 2 == 0) {
                evens.put(num, evens.getOrDefault(num, 0) + 1);
            } else {
                odds.put(num, odds.getOrDefault(num, 0) + 1);
            }
        }

        while(true) {
            int evenMax = 0;
            for (int i : evens.keySet()) {
                evenMax = Math.max(evenMax, evens.get(i));
            }
            int oddMax = 0;
            for (int i : odds.keySet()) {
                oddMax = Math.max(oddMax, odds.get(i));
            }
            if (evenMax != oddMax) {
                return (evenCount - evenMax) + (oddCount - oddMax);
            } else {
                evens.remove(evenMax);
                odds.remove(oddMax);
            }
        }
    }
}
