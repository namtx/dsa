package dev.namtx.leetcode;

public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        System.out.println(new MinimumLimitOfBallsInABag().minimumSize(new int[]{9}, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (nums.length == 1) {
            return (int) Math.ceil((float) max / (maxOperations + 1));
        }
        int left = (max == min) ? 1 : min;
        int right = max;
        while (left < right) {
            int operations = 0;
            int mid = (left + right) / 2;
            for (int num : nums) {
                if (num > mid) {
                    if (num % mid == 0) {
                        operations += (num / mid) - 1;
                    } else {
                        operations += (num / mid);
                    }
                }
            }
            if (operations > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
