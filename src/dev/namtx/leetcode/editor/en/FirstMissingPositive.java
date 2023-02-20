package dev.namtx.leetcode.editor.en;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                A[i] = 0;
            }
        }

        for (int i = 0; i < A.length; i++) {
            int idx = Math.abs(A[i])-1;
            if (idx >= 0 && idx < A.length) {
                if (A[idx] > 0) {
                    A[idx] *= -1;
                } else if (A[idx] == 0) {
                    A[idx] = -1 * (A.length+1);
                }
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (A[i-1] >= 0) return i;
        }

        return A.length+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
