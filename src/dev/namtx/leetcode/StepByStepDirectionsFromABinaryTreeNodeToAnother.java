package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 */
class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(6), new TreeNode(4))
        );

        System.out.println(new StepByStepDirectionsFromABinaryTreeNodeToAnother().getDirections(root, 3, 6));
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";
        TreeNode lcaNode = lca(root, startValue, destValue);

        StringBuilder fromLCAToStartValue = new StringBuilder();
        getDirection(lcaNode, startValue, fromLCAToStartValue);
        StringBuilder fromLCAToDestValue = new StringBuilder();
        getDirection(lcaNode, destValue, fromLCAToDestValue);


        StringBuilder direction = new StringBuilder();
        while (fromLCAToStartValue.length() != 0) {
            direction.append('U');
            fromLCAToStartValue.deleteCharAt(fromLCAToStartValue.length() - 1);
        }
        while (fromLCAToDestValue.length() != 0) {
            direction.append(fromLCAToDestValue.charAt(fromLCAToDestValue.length() - 1));
            fromLCAToDestValue.deleteCharAt(fromLCAToDestValue.length() - 1);
        }

        return direction.toString();
    }

    public boolean getDirection(TreeNode root, int k, StringBuilder sb) {
        if (root.val == k) return true;
        if (root.left != null && getDirection(root.left, k, sb)) {
            sb.append('L');
        } else if (root.right != null && getDirection(root.right, k, sb)) {
            sb.append('R');
        }

        return sb.length() != 0;
    }

    private TreeNode lca(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = lca(root.left, startValue, destValue);
        TreeNode right = lca(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
