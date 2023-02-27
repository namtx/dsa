package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCalls {
    //leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
        int currentPingIndex;
        List<Integer> pings;

        public RecentCounter() {
            this.currentPingIndex = 0;
            this.pings = new ArrayList<>();
            this.pings.add(0);
        }

        public int ping(int t) {
            this.pings.add(t);
            while (this.pings.get(this.currentPingIndex) + 3_000 < t) {
                this.currentPingIndex++;
            }
            if (this.currentPingIndex == 0) {
                return this.pings.size() - 1;
            }
            return this.pings.size() - this.currentPingIndex;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
