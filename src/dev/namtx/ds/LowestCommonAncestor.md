# Lowest Common Ancestor - LCA

### Eulerian Tour method
- O(1) time and O(nlogn) space

### DFS

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(p.val, q.val, root);
    }
    
    private TreeNode lca(int p, int q, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(p, q, root.left);
        TreeNode right = lca(p, q, root.right);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
```

