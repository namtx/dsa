#include <iostream>
#include <vector>

using namespace std;

// Build a balanced BST from the sorted array.
// The idea is to find the middle element and make it the root node.
// Then recursively build the left and right subtree.
class BalanceABST {
public:
  TreeNode *balanceBST(TreeNode *root) {
    vector<int> nodes;
    inorder(root, nodes);
    return buildTree(nodes, 0, nodes.size() - 1);
  }

private:
  void inorder(TreeNode *root, vector<int> &nodes) {
    if (root == nullptr) {
      return;
    }
    inorder(root->left, nodes);
    nodes.push_back(root->val);
    inorder(root->right, nodes);
  }

  TreeNode *buildTree(vector<int> &nodes, int start, int end) {
    if (start > end) {
      return nullptr;
    }
    int mid = start + (end - start) / 2;
    TreeNode *root = new TreeNode(nodes[mid]);
    root->left = buildTree(nodes, start, mid - 1);
    root->right = buildTree(nodes, mid + 1, end);
    return root;
  }
}
