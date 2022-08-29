package dev.namtx.leetcode.contest;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-308/problems/longest-subsequence-with-limited-sum/
 * <br>
 * <b>Input</b>: <i>nums</i> = [4,5,2,1], <i>queries</i> = [3,10,21]</i>
 * <br>
 * <b>Output</b>: [2,3,4]
 * <br>
 * <b>Explanation</b>: We answer the queries as follows:
 * <br>
 * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 * <br>
 * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 * <br>
 * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 */
public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int j = 0;
            while (j < nums.length && sum + nums[j] <= queries[i]) {
                sum += nums[j];
                j++;
            }
            if (j == nums.length) ans[i] = nums.length;
            else ans[i] = j;
        }

        return ans;
    }
}
