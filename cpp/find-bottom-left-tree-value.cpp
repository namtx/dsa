// https://leetcode.com/problems/find-bottom-left-tree-value

#include <iostream>
#include <queue>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {
public:
  int findBottomLeftValue(TreeNode *root) {
    queue<TreeNode *> q;
    q.push(root);
    int ans = root->val;
    while (!q.empty()) {
      TreeNode *node = q.front();
      q.pop();
      ans = node->val;
      if (node->right != nullptr) {
        q.push(node->right);
      }
      if (node->left != nullptr) {
        q.push(node->left);
      }
    }

    return ans;
  }
};
