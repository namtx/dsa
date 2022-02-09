package dev.namtx.leetcode;

public class FindPivotIndexII {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 7, 3, 6, 5, 6},
                {1, 2, 3},
                {2, 1, -1}
        };

        for (int[] testCase : testCases) {
            System.out.println(new FindPivotIndexII().pivotIndex(testCase));
        }
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) return i;
            left += nums[i];
        }

        return -1;
    }
}
