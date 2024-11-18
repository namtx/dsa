#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
  long long kthLargestLevelSum(TreeNode* root, int k) {
    queue<pair<TreeNode*, int>> q;

    q.push({root, 0});

    vector<long long> sums;

    while (!q.empty()) {
      auto [node, level] = q.front();
      q.pop();
      if (sums.size() == level) {
        sums.push_back(0);
      }
      sums[level] += node->val;
      if (node->left) {
        q.push({node->left, level + 1});
      }
      if (node->right) {
        q.push({node->right, level + 1});
      }
    }

    sort(sums.begin(), sums.end());

    if (sums.size() + 1 < k) {
      return -1;
    }

    return sums[sums.size() - k];
  }
};
