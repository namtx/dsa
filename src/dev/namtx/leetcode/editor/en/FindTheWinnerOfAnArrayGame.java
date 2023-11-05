package dev.namtx.leetcode.editor.en;

import java.util.*;

public class FindTheWinnerOfAnArrayGame {
    public static void main(String[] args) {
        Solution solution = new FindTheWinnerOfAnArrayGame().new Solution();
        System.out.println(solution.getWinner(new int[]{2,1,3,5,4,6,3},3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getWinner(int[] arr, int k) {
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }

        if (k >= arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }

        int currentWinner = arr[0];
        int consecutiveWins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currentWinner > arr[i]) {
                consecutiveWins++;
            } else {
                currentWinner = arr[i];
                consecutiveWins=1;
            }

            if (consecutiveWins == k) {
                return currentWinner;
            }
        }

        return currentWinner;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
