package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, new Node(6), new Node(7), null);

        new PopulatingNextRightPointersInEachNode().connect(root);
        System.out.println(root);
    }

    public Node connect(Node root) {
        List<Node> nodes = new ArrayList<>();
        if (root == null) {
            return null;
        }

        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                if (i < nodes.size() - 1) {
                    nodes.get(i).next = nodes.get(i + 1);
                }
                if (nodes.get(i).left != null) {
                    nextLevel.add(nodes.get(i).left);
                    nextLevel.add(nodes.get(i).right);
                }
            }
            nodes = nextLevel;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
