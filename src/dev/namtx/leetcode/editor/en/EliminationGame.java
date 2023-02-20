package dev.namtx.leetcode.editor.en;

import java.util.Stack;

public class EliminationGame {
    public static void main(String[] args) {
        Solution solution = new EliminationGame().new Solution();
        System.out.println(solution.lastRemaining(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n) {
            boolean left = true;
            int remaining = n;
            int step = 1;
            int head = 1;
            while(remaining > 1) {
                if (left || remaining % 2 == 1) {
                    head += step;
                }
                remaining /= 2;
                step *= 2;
                left = !left;
            }

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
