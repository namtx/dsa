package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < N - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) { // already checked
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int h = N - 1;
            while (l < h) {
                int s = nums[l] + nums[h];
                if (s > target) {
                    h--;
                } else if (s < target) {
                    l++;
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[l]);
                    item.add(nums[h]);

                    r.add(item);
                    while (l < h && nums[l] == nums[l + 1])
                        l++;

                    while (l < h && nums[h] == nums[h - 1])
                        h--;

                    l++;
                    h--;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
