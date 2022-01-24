package dev.namtx.ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
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
