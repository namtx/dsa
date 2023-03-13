package dev.namtx.ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode deserialize(int[] nodes) {
        if (nodes.length == 0) return null;
        ListNode head = new ListNode(nodes[0]);
        ListNode current = head;
        for (int i = 1; i < nodes.length; i++) {
            current.next = new ListNode(nodes[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(val);
        ListNode p = next;
        while (p != null) {
            sb.append("->").append(p.val);
            p = p.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
