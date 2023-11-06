package dev.namtx.leetcode.editor.en;

import java.util.PriorityQueue;

public class SeatReservationManager {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class SeatManager {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }
    
    public int reserve() {
        return pq.remove();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
//leetcode submit region end(Prohibit modification and deletion)
