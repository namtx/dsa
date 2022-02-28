package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(9)
        )))));
        ListNode l2 = new ListNode(
                9, new ListNode(
                9, new ListNode(9)
        ));
        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curry = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + curry;
            if (val >= 10) {
                curry = 1;
                val -= 10;
            } else {
                curry = 0;
            }
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            int val = l2.val + curry;
            if (val >= 10) {
                curry = 1;
                val -= 10;
            } else {
                curry = 0;
            }
            current.next = new ListNode(val);
            current = current.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + curry;
            if (val >= 10) {
                curry = 1;
                val -= 10;
            } else {
                curry = 0;
            }
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
        }
        if (curry == 1) {
            current.next = new ListNode(1);
        }

        return head.next;
    }
}

