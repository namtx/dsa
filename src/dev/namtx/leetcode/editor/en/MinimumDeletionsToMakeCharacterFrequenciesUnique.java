package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeCharacterFrequenciesUnique().new Solution();
        System.out.println(solution.minDeletions("ceabaacb"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletions(String s) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Character, Integer> cm = new HashMap<>();

        for (char c: s.toCharArray()) {
            cm.put(c, cm.getOrDefault(c, 0)+1);
        }
        for (int k: cm.values()) {
            m.put(k, m.getOrDefault(k, 0)+1);
        }

        int ans = 0;
        for (int i = s.length(); i >= 1; i--) {
            int c = m.getOrDefault(i, 0);
            if (c > 1) {
                ans += c - 1;
                m.put(i-1, m.getOrDefault(i-1, 0)+c-1);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
