package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Integer> m = new HashMap<>();
        for (String equation: equations) {
            int first = m.getOrDefault(equation.charAt(0), equation.charAt(0)-'a');
            int second = m.getOrDefault(equation.charAt(3), equation.charAt(3)-'a');
            if (equation.charAt(1) == '!') {
                if (first == second) {
                    return false;
                }
            } else {
                if (m.containsKey(equation.charAt(0)) && m.containsKey(equation.charAt(3))) {
                    if (first != second) {
                        return false;
                    }
                }
            }
            m.put(equation.charAt(0), first);
            m.put(equation.charAt(3), second);
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
