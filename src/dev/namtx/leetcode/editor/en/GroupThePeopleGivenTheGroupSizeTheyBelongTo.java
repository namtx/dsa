package dev.namtx.leetcode.editor.en;

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo().new Solution();
        System.out.println(solution.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> m = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<List<Integer>> l;
            if (m.containsKey(groupSizes[i])) {
                l = m.get(groupSizes[i]);
            } else {
                l = new ArrayList<>();
                m.put(groupSizes[i], l);
            }
            boolean filled = false;
            for (List<Integer> ll : l) {
                if (ll.size() < groupSizes[i]) {
                    ll.add(i);
                    filled = true;
                    break;
                }
            }
            if (!filled) {
                l.add(new ArrayList<>(List.of(i)));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> e: m.entrySet()) {
            ans.addAll(e.getValue());
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
