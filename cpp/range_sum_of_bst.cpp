#include <iostream>

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
  int rangeSumBST(TreeNode *root, int low, int high) {
    if (root == nullptr)
      return 0;
    if (root->val < low || root->val > high)
      return rangeSumBST(root->left, low, high) +
             rangeSumBST(root->right, low, high);

    return root->val + rangeSumBST(root->left, low, high) +
           rangeSumBST(root->right, low, high);
  }
};
