package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode first  = fast;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int tmp = slow.val;
        slow.val = first.val;
        first.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(100, new ListNode(99));
        System.out.println(new SwappingNodesInALinkedList().swapNodes(head, 2));
    }
}
