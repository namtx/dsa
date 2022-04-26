package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (!longEnough(head, k)) return head;

        int i = 0;
        ListNode prev = null;
        ListNode current = head;
        while (i < k) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        ListNode h = prev;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = reverseKGroup(current, k);

        return h;
    }

    private boolean longEnough(ListNode node, int k) {
        int l = 1;
        while (node.next != null) {
            node = node.next;
            l++;
            if (l == k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(head, 1));
    }
}
