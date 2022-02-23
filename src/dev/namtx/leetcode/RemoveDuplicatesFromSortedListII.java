package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println(new RemoveDuplicatesFromSortedListII().iterativelyDeleteDuplicates(head));
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

    public ListNode iterativelyDeleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev = cur;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
