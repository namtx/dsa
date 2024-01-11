#include <cstdlib>
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
  int maxAncestorDiff(TreeNode *root) {
    if (root == nullptr)
      return 0;
    dfs(root);

    return ans;
  }

  vector<int> dfs(TreeNode *root) {
    // base case
    if (root->left == nullptr && root->right == nullptr) {
      return {root->val};
    }
    vector<int> l;
    if (root->left != nullptr) {
      vector<int> l = dfs(root->left);
      for (auto i : l) {
        ans = std::max(ans, abs(root->val - i));
      }
    }
    l.push_back(root->val);
    vector<int> r;
    if (root->right != nullptr) {
      vector<int> l = dfs(root->right);
      for (auto i : l) {
        l.push_back(i);
        ans = std::max(ans, abs(root->val - i));
      }
    }
    return l;
  }
};
