package dev.namtx.leetcode;

import dev.namtx.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> m = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (!m.containsKey(n)) {
            List<TreeNode> l = new ArrayList<>();
            if (n == 1) {
                l.add(new TreeNode(0));
            } else if (n % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    int j = n - i - 1;
                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode node = new TreeNode(0, left, right);
                            l.add(node);
                        }
                    }
                }
            }
            m.put(n, l);
        }

        return m.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new AllPossibleFullBinaryTrees().allPossibleFBT(7));
    }
}
