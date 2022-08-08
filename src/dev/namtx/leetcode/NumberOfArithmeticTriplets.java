package dev.namtx.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-305/problems/number-of-arithmetic-triplets/
 */
public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int N = nums.length;
        int i = 0;
        while (i <= N - 3) {
            int j = i + 1;
            while (j <= N - 2 && nums[j] != nums[i] + diff) {
                j++;
            }
            if (j > N - 2) {
                i++;
                continue;
            }
            int k = j + 1;
            while (k <= N - 1 && nums[k] != nums[j] + diff) {
                k++;
            }
            if (k > N - 1) {
                i++;
                continue;
            }
            i++;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticTriplets().arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
    }
}
