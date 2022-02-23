package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            int val = head.val;
            while (head != null && head.val == val) {
                head = head.next;
            }
            return deleteDuplicates(head);
        }
        return head;
    }
}
