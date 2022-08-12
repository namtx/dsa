package dev.namtx.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequenceII {
    public static void main(String[] args) {

//        System.out.println(new LongestIncreasingSubsequenceII().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LongestIncreasingSubsequenceII().pathOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = lowerBoundIndex(list, num);
                list.set(i, num);
            }
        }

        return list.size();
    }

    List<Integer> pathOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        List<Integer> subIndex = new ArrayList<>();
        int[] path = new int[n]; // path[i] point to the index of previous number in LIS
        Arrays.fill(path, -1);

        for (int i = 0; i < nums.length; i++) {
            if (sub.isEmpty() || sub.get(sub.size()-1) < nums[i]) {
                path[i] = sub.isEmpty() ? -1 : subIndex.get(sub.size()-1);
                sub.add(nums[i]);
                subIndex.add(i);
            } else {
                int idx = lowerBoundIndex(sub, nums[i]);
                path[i] = idx == 0 ? -1 : subIndex.get(idx-1);
                sub.set(idx, nums[i]);
                subIndex.set(idx, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int t = subIndex.get(subIndex.size()-1);
        while(t != -1) {
            ans.add(nums[t]);
            t = path[t];
        }
        Collections.reverse(ans);
        return ans;
    }

    private int lowerBoundIndex(List<Integer> list, int k) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
