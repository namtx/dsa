package dev.namtx.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/continuous-subarray-sum
 * <p>
 * We have `(a+(n*x))%x is same as (a%x)`
 * <p>
 * For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].
 * We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k
 */
public class ContinuousSubArraySum {
    public static void main(String[] args) {
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod == 0 && i >= 1) return true;
            if (!m.containsKey(mod)) {
                m.put(mod, i);
            } else {
                int lastIndex = m.get(mod);
                if (i - lastIndex > 1) return true;
            }
        }
        return false;
    }
}
