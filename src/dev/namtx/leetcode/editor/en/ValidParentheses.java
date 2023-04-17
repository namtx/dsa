package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("[(){}]"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>();
        m.put('}', '{');
        m.put(']', '[');
        m.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (isOpenParentheses(c)) {
                    stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.peek() != m.get(c)) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenParentheses(char c) {
        return (c == '(' || c == '[' || c == '{');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
