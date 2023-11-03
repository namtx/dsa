package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(0));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = List.of(1);
        for (int i = 2; i <= rowIndex+1; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    list.add(1);
                } else if (j == i-1) {
                    list.add(1);
                } else {
                    list.add(j, prev.get(j)+prev.get(j-1));
                }
            }
            prev = list;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
