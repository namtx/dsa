package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(9));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 1);
        helper(n,m);
        return m.get(n);
    }

    private int helper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);

        int max;
        for (int i = 2; i < n-1; i++) {
            max = Math.max(cache.getOrDefault(n, n-1), Math.max(i, helper(i, cache))*Math.max(n-i, helper(n-i, cache)));
            cache.put(n, max);
        }
        cache.put(n, Math.max(n-1, cache.getOrDefault(n, n-1)));
        return cache.getOrDefault(n, n-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
