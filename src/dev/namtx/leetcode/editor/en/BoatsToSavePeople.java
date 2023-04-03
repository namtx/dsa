package dev.namtx.leetcode.editor.en;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        Solution solution = new BoatsToSavePeople().new Solution();
        System.out.println(solution.numRescueBoats(new int[]{3, 8, 4, 9, 2, 2, 7, 1, 6, 10, 6, 7, 1, 7, 7, 6, 4, 4, 10, 1}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int left = 0;
            int right = people.length - 1;
            int ans = 0;

            while (left < right) {
                int total = people[left] + people[right];
                if (total <= limit) {
                    ans++;
                    left++;
                    right--;
                } else if (people[right] <= limit) {
                    ans++;
                    right--;
                }
            }
            if (left == right) {
                ans++;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
