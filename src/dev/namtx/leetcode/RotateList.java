package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        head = reverse(head);
        int s = size(head);
        if (k > s) {
            k = k % s;
        }
        int pointer = 1;
        ListNode current = head;
        while(pointer < k) {
            current = current.next;
            pointer++;
        }
        ListNode next = current.next;
        current.next = null;
        ListNode h = reverse(head);
        ListNode tmpHead = h;
        while(tmpHead.next != null) {
            tmpHead = tmpHead.next;
        }
        tmpHead.next = reverse(next);

        return h;
    }

    private int size(ListNode head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new RotateList().rotateRight(head, 2));
    }
}
