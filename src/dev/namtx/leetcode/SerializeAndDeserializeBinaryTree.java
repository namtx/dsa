package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> sb = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            List<String> levelSb = new ArrayList<>();
            int nonNullCount = 0;
            for (TreeNode node : nodes) {
                if (node == null) {
                    levelSb.add("null");
                } else {
                    nonNullCount++;
                    levelSb.add(node.val + "");
                    children.add(node.left);
                    children.add(node.right);
                }
            }
            if (nonNullCount != 0) {
                nodes = children;
                sb.addAll(levelSb);
            } else break;
        }

        return String.join(",", sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        int i = 0;
        while(i < nodes.length) {
            List<TreeNode> children = new ArrayList<>();
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));

        System.out.println(new SerializeAndDeserializeBinaryTree().serialize(root));
    }
}
