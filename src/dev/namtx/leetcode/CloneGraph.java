package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        System.out.println(new CloneGraph().cloneGraph(node1));
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> cache = new java.util.HashMap<>();
        Node cloned = helper(node, cache);
        return cloned;
    }

    private Node helper(Node node, Map<Integer, Node> cache) {
        Node cloned = new Node(node.val);
        cache.put(node.val, cloned);
        List<Node> clonedNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            if (cache.containsKey(neighbor.val)) {
                clonedNeighbors.add(cache.get(neighbor.val));
            } else {
                clonedNeighbors.add(helper(neighbor, cache));
            }
        }
        cloned.neighbors = clonedNeighbors;

        return cloned;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
