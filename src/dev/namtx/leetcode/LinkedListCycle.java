package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else return false;
            if (fast == null) return false;
            if (slow == fast) return true;
        }

        return true;
    }
}
