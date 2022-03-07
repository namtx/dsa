package dev.namtx.leetcode;

public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3, 4, 5, 1, 2, 1000}));
    }

    public int rob(int[] nums) {
        int[] withFirstHouse = new int[nums.length];
        int[] withoutFirstHouse = new int[nums.length];
        withFirstHouse[0] = nums[0];
        withFirstHouse[1] = nums[0];
        withoutFirstHouse[0] = 0;
        withoutFirstHouse[1] = nums[1];

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length - 1; i++) {
            withFirstHouse[i] = Math.max(nums[i] + withFirstHouse[i - 2], withFirstHouse[i - 1]);
            withoutFirstHouse[i] = Math.max(nums[i] + withoutFirstHouse[i - 2], withoutFirstHouse[i - 1]);
        }

        int with = Math.max(withFirstHouse[nums.length - 2], withFirstHouse[nums.length - 3]);
        int without = Math.max(withoutFirstHouse[nums.length - 2], nums[nums.length - 1] + withoutFirstHouse[nums.length - 3]);

        return Math.max(without, with);
    }
}
