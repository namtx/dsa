package dev.namtx.leetcode.editor.en;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        Solution solution = new ValidateStackSequences().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
