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
  int ans = 0;
  int maxAncestorDiff(TreeNode *root) {
    if (root == nullptr)
      return 0;
    dfs(root, root->val, root->val);

    return ans;
  }

  void dfs(TreeNode *root, int currentMax, int currentMin) {
    if (root == nullptr)
      return;

    ans = std::max(ans, std::max(abs(root->val - currentMax),
                                 abs(root->val - currentMin)));

    currentMax = std::max(root->val, currentMax);
    currentMin = std::min(root->val, currentMin);

    dfs(root->left, currentMax, currentMin);
    dfs(root->right, currentMax, currentMin);
  }
};
