package dev.namtx.leetcode.editor.en;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int N = word1.length();
            int M = word2.length();
            if (N == 0 || M == 0) {
                return Math.max(N, M); // adding only
            }

            // dp[i][j] represents the minimum number of operations required to transform the substring word1[0...i-1]
            // into substring word2[0...j-1]
            int[][] dp = new int[N+1][M+1];
            for (int i = 0; i <= N; i++) {
                // from the substring word1[0...i-1] into empty string, that requires `i` delete operations
                dp[i][0] = i;
            }
            for (int i = 1; i <= M; i++) {
                // that also requires `i` adding operations to turn empty string into `i` length string
                dp[0][i] = i;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i+1][j+1] = dp[i][j];
                    } else {
                        dp[i+1][j+1] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]));
                    }
                }
            }

            return dp[N][M];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
