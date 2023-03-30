package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public static void main(String[] args) {
        Solution solution = new ScrambleString().new Solution();
        System.out.println(solution.isScramble("abc", "bca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, Boolean> memo = new HashMap<>();

        public boolean isScramble(String s1, String s2) {
            return solve(s1, s2);
        }

        private boolean solve(String s1, String s2) {
            if (s1.length() == 1) return s1.equals(s2);
            if (s1.equals(s2)) return true;
            String key = s1 + "*" + s2;
            if (memo.containsKey(key)) return memo.get(key);

            int[] charCountS1 = new int[26];
            int[] charCountS2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                charCountS1[s1.charAt(i) - 'a']++;
                charCountS2[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < charCountS1.length; i++) {
                if (charCountS1[i] != charCountS2[i]) {
                    memo.put(key, false);
                    return false;
                }
            }

            int n = s1.length();
            for (int i = 1; i < n; i++) {
                boolean r = (solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i, n), s2.substring(i, n)))
                        || (solve(s1.substring(0, i), s2.substring(n - i)) && solve(s1.substring(i, n), s2.substring(0, n - i)));
                if (r) {
                    return true;
                }
            }
            memo.put(key, false);
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
