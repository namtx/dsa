package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        Solution solution = new BuildAnArrayWithStackOperations().new Solution();
        System.out.println(solution.buildArray(new int[]{2,3,5}, 7));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> out = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int currentIndex = 0;
        for (int i = 1; i  <= n; i++) {
            if (currentIndex == target.length) return out;
            push(s, i, out);
            if (i != target[currentIndex]) {
                pop(s, out);
            } else {
                currentIndex++;
            }
        }
        return out;
    }

    private void push(Stack<Integer> s, int num, List<String>out) {
        s.push(num);
        out.add("Push");
    }

    private void pop(Stack<Integer> s, List<String>out) {
        s.pop();
        out.add("Pop");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
