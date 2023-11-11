//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

# include<vector>
# include<iostream>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;

  TreeNode(): val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x): val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right): val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
      vector<int> r;
      if (root == nullptr) {
        return r;
      }
      r.push_back(root->val);
      vector<int> left = preorderTraversal(root->left);
      r.insert(r.end(), left.begin(), left.end());
      vector<int> right = preorderTraversal(root->right);
      r.insert(r.end(), right.begin(), right.end());

      return r;
    }
};

int main (int argc, char *argv[]) {
  Solution solution = Solution();
  TreeNode third = TreeNode(3);
  TreeNode second = TreeNode(2);
  second.right = &third;
  TreeNode root = TreeNode(1, nullptr, &second);
  vector<int> result = solution.preorderTraversal(&root);
  for (int e: result) {
    cout << e << " ";
  }

  cout << endl;

  return 0;
}
