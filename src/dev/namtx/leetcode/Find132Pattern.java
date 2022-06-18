package dev.namtx.leetcode;

public class Find132Pattern {
    public static void main(String[] args) {
        System.out.println(new Find132Pattern().find132pattern(new int[]{3, 1, 4, 2}));
    }
    // TODO: Fix it

    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] <= nums[i] + 2) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]) return true;
                }
            }
        }

        return false;
    }
}
