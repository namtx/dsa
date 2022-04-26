package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        traverse(root1, list1);
        traverse(root2, list2);

        int i = 0;
        int j = 0;
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i++));
            } else if (list1.get(i) >= list2.get(j)) {
                ans.add(list2.get(j++));
            }
        }
        while(i < list1.size()) {
            ans.add(list1.get(i++));
        }
        while(j < list1.size()) {
            ans.add(list2.get(j++));
        }

        return ans;
    }


    private void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traverse(root.left, ans);
        ans.add(root.val);
        traverse(root.right, ans);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0,new TreeNode(-10), new TreeNode(10));
        TreeNode root2 = new TreeNode(5, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(7));

        System.out.println(new AllElementsInTwoBinarySearchTrees().getAllElements(null, root2));
    }
}
