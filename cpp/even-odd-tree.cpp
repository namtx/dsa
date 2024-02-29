// https://leetcode.com/problems/even-odd-tree

#include <iostream>
#include <queue>

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
  bool isEvenOddTree(TreeNode *root) {
    int minEven = 0;
    int maxOdd = INT_MAX;

    int level = 0;
    queue<pair<TreeNode *, int>> q;
    q.push({root, 0});
    while (!q.empty()) {
      auto p = q.front();
      q.pop();
      if (p.first == nullptr)
        continue;
      if (p.second % 2 == p.first->val % 2) {
        return false;
      }
      if (p.second % 2 == 0) {
        maxOdd = INT_MAX;
        if (p.first->val <= minEven)
          return false;
        minEven = p.first->val;
        q.push({p.first->left, p.second + 1});
        q.push({p.first->right, p.second + 1});
      } else {
        minEven = 0;
        if (p.first->val >= maxOdd)
          return false;
        maxOdd = p.first->val;
        q.push({p.first->left, p.second + 1});
        q.push({p.first->right, p.second + 1});
      }
    }

    return true;
  }
};
