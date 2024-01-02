#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};
static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  vector<int> rightSideView(TreeNode *root) {
    if (root == nullptr)
      return {};
    vector<int> ans;
    vector<TreeNode *> v;
    v.push_back(root);
    while (v.size() > 0) {
      int s = static_cast<int>(v.size());
      ans.push_back(v[s - 1]->val);
      vector<TreeNode *> x;
      for (auto node : v) {
        if (node->left != nullptr) {
          x.push_back(node->left);
        }
        if (node->right != nullptr) {
          x.push_back(node->right);
        }
      }
      v = x;
    }
    return ans;
  }
};
