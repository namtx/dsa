package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.ListNode;
import dev.namtx.ds.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
        ListNode head = ListNode.deserialize(new int[]{-10, -3, 0, 5, 9});
        solution.sortedListToBST(head);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return sortedListToBST(head, null);
        }

        public TreeNode sortedListToBST(ListNode head, ListNode tail) {
            if (head == null) return null;
            if (head == tail) return null;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }

            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head, slow);
            root.right = sortedListToBST(slow.next, null);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
