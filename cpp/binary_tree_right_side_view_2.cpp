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
  vector<int> rightSideView(TreeNode *root) {
    if (root == nullptr)
      return {};

    vector<int> ans;

    rightView(root, ans, 0);

    return ans;
  }

  void rightView(TreeNode *root, vector<int> &ans, int level) {
    if (root == nullptr)
      return;
    if (static_cast<int>(ans.size()) == level) {
      ans.push_back(root->val);
    } else {
      ans[level] = root->val;
    }

    rightView(root->left, ans, level + 1);
    rightView(root->right, ans, level + 1);
  }
};
