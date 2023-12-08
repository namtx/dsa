#include <iostream>
#include <string>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
  TreeNode(int val, TreeNode *left, TreeNode *right)
      : val(val), left(left), right(right) {}
};

class Solution {
public:
  string tree2str(TreeNode *root) {
    if (root == nullptr)
      return "";

    if (root->left == nullptr && root->right == nullptr) {
      return to_string(root->val);
    } else if (root->right == nullptr) {
      return to_string(root->val) + "(" + tree2str(root->left) + ")";
    } else if (root->left == nullptr) {
      return to_string(root->val) + "()" + "(" + tree2str(root->right) + ")";
    }

    return to_string(root->val) + "(" + tree2str(root->left) + ")" + "(" +
           tree2str(root->right) + ")";
  }
};

int main(int argc, char *argv[]) {
  TreeNode *root = new TreeNode(1, new TreeNode(2, nullptr, new TreeNode(4)),
                                new TreeNode(3));

  cout << (new Solution)->tree2str(root);
  return 0;
}
