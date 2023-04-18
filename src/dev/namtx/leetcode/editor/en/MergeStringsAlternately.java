package dev.namtx.leetcode.editor.en;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        Solution solution = new MergeStringsAlternately().new Solution();
        System.out.println(solution.mergeAlternately("ab", "pqrs"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < word1.length() && j < word2.length()) {
                sb.append(word1.charAt(i++));
                sb.append(word2.charAt(j++));
            }
            while (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
            while (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
