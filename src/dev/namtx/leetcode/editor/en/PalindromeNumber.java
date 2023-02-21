package dev.namtx.leetcode.editor.en;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            int num = x;
            int p = 0;
            while (num > 0) {
                p = p * 10 + num % 10;
                num /= 10;
            }

            return (p == x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
