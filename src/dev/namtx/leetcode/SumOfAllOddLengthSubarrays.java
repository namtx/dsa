package dev.namtx.leetcode;

public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        System.out.println(new SumOfAllOddLengthSubarrays().sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] += sums[i - 1] + arr[i];
        }

        int len = 1;
        int ans = 0;
        while (len <= arr.length) {
            for (int i = 0; i < arr.length - len + 1; i++) {
                ans += sums[i + len - 1] - (i > 0 ? sums[i - 1] : 0);
            }
            len += 2;
        }

        return ans;
    }
}
