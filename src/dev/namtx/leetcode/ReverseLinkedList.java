package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(
                new ReverseLinkedList()
                        .reverseList(
                            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
                        )
        );
    }
}
