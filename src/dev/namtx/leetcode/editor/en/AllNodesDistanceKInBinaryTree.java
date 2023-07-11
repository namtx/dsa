package dev.namtx.leetcode.editor.en;

import dev.namtx.ds.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
//        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
//        TreeNode root = new TreeNode(
//                3,
//                target,
//                new TreeNode(1, new TreeNode(0), new TreeNode(8))
//        );
//        int k = 2;
        TreeNode target = new TreeNode(1);
        TreeNode root = target;
        int k = 3;
        System.out.println(solution.distanceK(root, target, k));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, parentMap);

        boolean[] visited = new boolean[501];
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        while(k > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                visited[node.val] = true;
                if (node.left != null && !visited[node.left.val]) {
                    q.offer(node.left);
                }
                if (node.right != null && !visited[node.right.val]) {
                    q.offer(node.right);
                }
                TreeNode parentNode = parentMap.get(node);
                if (parentNode != null && !visited[parentNode.val]) {
                    q.offer(parentMap.get(node));
                }
            }
            k--;
        }

        while(q.size() > 0) {
            ans.add(q.poll().val);
        }

        return ans;
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left, parentMap);
        }
        if (root.right !=  null) {
            parentMap.put(root.right, root);
            dfs(root.right, parentMap);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
