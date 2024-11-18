#include <iostream>
#include <vector>
#include <map>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    // descriptions[i] = [parent, child, isLeft]
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
      TreeNode *root;
      map<int, pair<TreeNode*, bool>> m;
      for (size_t i = 0; i < descriptions.size(); i++) {
        pair<TreeNode *, bool> childPair = { new TreeNode(descriptions[i][1]), false };
        if (m.find(descriptions[i][0]) == m.end()) {
          m[descriptions[i][0]] = { new TreeNode(descriptions[i][0]), true };
        }
        if (descriptions[i][2] == 0) {
          m[descriptions[i][0]]->left = child;
        } else {
          m[descriptions[i][0]]->right = child;
        }
      }
    }
};
