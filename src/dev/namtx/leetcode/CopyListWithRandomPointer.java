package dev.namtx.leetcode;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println(new CopyListWithRandomPointer().copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> m = new HashMap<>();

        Node pointer = head;
        Node dump = new Node(-1);
        Node current = dump;
        while (pointer != null) {
            Node newNode = new Node(pointer.val);
            current.next = newNode;
            m.put(pointer, newNode);
            pointer = pointer.next;
            current = newNode;
        }
        pointer = head;
        while (pointer != null) {
            Node random = pointer.random;
            if (random != null) {
                m.get(pointer).random = m.get(random);
            }
            pointer = pointer.next;
        }

        return dump.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(val);
            Node p = next;
            while (p != null) {
                sb.append("->").append(p.val);
                p = p.next;
            }
            sb.append("]");

            return sb.toString();
        }
    }
}
