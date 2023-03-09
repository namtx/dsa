package dev.namtx.leetcode.editor.en;

public class StringCompression {
    public static void main(String[] args) {
        Solution solution = new StringCompression().new Solution();
        System.out.println(solution.compress("a".toCharArray()));
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compress(char[] chars) {
            int currentCount = 1;
            int ans = 0;
            int n = chars.length;
            for (int i = 1; i < n; i++) {
                if (chars[i] == chars[i-1]) {
                    currentCount++;
                } else {
                    if (currentCount == 1)  {
                        ans += 1;
                    } else if (currentCount > 1) {
                        ans += 1 + Math.floor(Math.log10(currentCount)) + 1;
                    }
                    currentCount = 1;
                }
            }

            if (currentCount == 1)  {
                ans += 1;
            } else if (currentCount > 1) {
                ans += 1 + Math.floor(Math.log10(currentCount)) + 1;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
