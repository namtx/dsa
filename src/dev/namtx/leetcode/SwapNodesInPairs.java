package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(new SwapNodesInPairs().swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = head.next;
        head.next = swapPairs(dummy.next);
        dummy.next = head;

        return dummy;
    }
}
