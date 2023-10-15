package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public static void main(String[] args) {
        Solution solution = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean winnerOfGame(String colors) {
        Map<Character, Integer> c = new HashMap<>();
        c.put('A', 0);
        c.put('B', 0);

        for (int i = 0; i < colors.length(); i++) {
            char x = colors.charAt(i);
            int count = 0;

            while (i < colors.length() && colors.charAt(i) == x) {
                i++;
                count++;
            }

            c.put(x, c.get(x) + Math.max(count - 2, 0));
            i--;
        }

        return c.get('A') > c.get('B');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
