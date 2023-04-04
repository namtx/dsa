package dev.namtx.leetcode.editor.en;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        Solution solution = new OptimalPartitionOfString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionString(String s) {
            int[] characterCount = new int[26];
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (characterCount[s.charAt(i) - 'a'] == 1) {
                    ans++;
                    characterCount = new int[26];
                }
                characterCount[s.charAt(i) - 'a'] = 1;
            }

            return ans + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
