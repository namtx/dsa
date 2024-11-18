#include <iostream>
#include <vector>
#include <queue>
#include "tree_node.h"

using namespace std;

class Solution {
public:
  vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
    vector<TreeNode*> result;
    result.push_back(root);
    while(!to_delete.empty()) {
      for (size_t i = 0; i < result.length; i++) {
        result[i] = deleteNode(node, to_delete, result);
        if (result[i] == nullptr) {
          result.earse(result.begin()+i);
        }
      }
    }
    return result;
  }

private:
  TreeNode* deleteNode(TreeNode* root, vector<int>& to_delete, vector<TreeNode*>& result) {
    if (!root) {
      return nullptr;
    }
    cout << "root: " << root->val << endl;
    if (to_delete.empty()) {
      return root;
    }

    root->left = deleteNode(root->left, to_delete, result);
    root->right = deleteNode(root->right, to_delete, result);
    if (find(to_delete.begin(), to_delete.end(), root->val) != to_delete.end()) {
      result.push_back(root->left);
      result.push_back(root->right);
      to_delete.erase(remove(to_delete.begin(), to_delete.end(), root->val), to_delete.end());
      return nullptr;
    }
    return root;
  }
};

int main (int argc, char *argv[]) {
  TreeNode* root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
  vector<int> to_delete = {3, 5};

  Solution s;
  s.delNodes(root, to_delete);
  return 0;
}

