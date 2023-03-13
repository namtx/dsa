package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.ListNode;

import java.util.Random;

public class LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new LinkedListRandomNode().new Solution(head);
        System.out.println(solution.getRandom());
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    public int getRandom() {
        int i = 1;
        int result = this.head.val;
        ListNode current = this.head.next;
        while(current != null) {
            if (random.nextDouble() < 1.0 / (i+1)) {
                result = current.val;
            }
            i++;
            current = current.next;
        }

        return result;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
