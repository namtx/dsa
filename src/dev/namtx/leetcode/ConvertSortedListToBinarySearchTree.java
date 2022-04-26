package dev.namtx.leetcode;

import dev.namtx.ds.ListNode;
import dev.namtx.ds.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(head);
        System.out.println(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return construct(head);
    }

    private TreeNode construct(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prevMid = findPrevMid(head);
        ListNode mid = prevMid.next;
        TreeNode node = new TreeNode(mid.val);
        prevMid.next = null;
        node.left = construct(head);
        node.right = construct(mid.next);

        return node;
    }

    private ListNode findPrevMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevMid = new ListNode(-1);
        prevMid.next = slow;

        while (fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prevMid;
    }
}
