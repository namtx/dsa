// https://leetcode.com/problems/diameter-of-binary-tree

#include <iostream>
#include <vector>

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
  int ans = 0;
  int diameterOfBinaryTree(TreeNode *root) {
    maxDepth(root);
    return ans;
  }

  int maxDepth(TreeNode *root) {
    if (root == nullptr)
      return 0;
    int left = maxDepth(root->left);
    int right = maxDepth(root->right);
    ans = std::max(ans, left + right + 1);
    return 1 + std::max(left, right);
  }
};
