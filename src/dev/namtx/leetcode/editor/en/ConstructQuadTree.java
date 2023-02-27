package dev.namtx.leetcode.editor.en;

public class ConstructQuadTree {
    public static void main(String[] args) {
        Solution solution = new ConstructQuadTree().new Solution();
        solution.construct(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}});
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

    class Solution {
        public Node construct(int[][] grid) {
            return helper(grid, grid.length, 0, 0);
        }

        private Node helper(int[][] grid, int n, int x, int y) {
            if (n == 1) {
                return new Node(grid[x][y] == 1, true, null, null, null, null);
            } else {
                Node topLeft = helper(grid, n / 2, x, y);
                Node topRight = helper(grid, n / 2, x, y + n / 2);
                Node bottomLeft = helper(grid, n / 2, x + n / 2, y);
                Node bottomRight = helper(grid, n / 2, x + n / 2, y + n / 2);

                boolean val = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val;
                boolean isLeaf = (topLeft.val == topRight.val) && (topLeft.val == bottomLeft.val) && (topLeft.val == bottomRight.val) && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;

                if (isLeaf) {
                    return new Node(topLeft.val, true, null, null, null, null);
                } else {
                    return new Node(val, false, topLeft, topRight, bottomLeft, bottomRight);
                }
            }
        }

        class Node {
            public boolean val;
            public boolean isLeaf;
            public Node topLeft;
            public Node topRight;
            public Node bottomLeft;
            public Node bottomRight;


            public Node() {
                this.val = false;
                this.isLeaf = false;
                this.topLeft = null;
                this.topRight = null;
                this.bottomLeft = null;
                this.bottomRight = null;
            }

            public Node(boolean val, boolean isLeaf) {
                this.val = val;
                this.isLeaf = isLeaf;
                this.topLeft = null;
                this.topRight = null;
                this.bottomLeft = null;
                this.bottomRight = null;
            }

            public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
                this.val = val;
                this.isLeaf = isLeaf;
                this.topLeft = topLeft;
                this.topRight = topRight;
                this.bottomLeft = bottomLeft;
                this.bottomRight = bottomRight;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
