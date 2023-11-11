#include <iostream>
#include <map>
#include <unordered_map>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;

  TreeNode() : val(0), left(nullptr), right(nullptr){};
  TreeNode(int val) : val(val), left(nullptr), right(nullptr){};
  TreeNode(int val, TreeNode *left, TreeNode *right)
      : val(0), left(left), right(right){};
};

class Solution {
public:
  int maxLevelSum(TreeNode *root) {
    unordered_map<int, int> m;
    helper(root, &m, 1);
    int max = root->val;
    int level = 1;
    for (const auto &pair : m) {
      if (pair.second > max) {
        max = pair.second;
        level = pair.first;
      } else if (pair.second == max) {
        level = min(level, pair.first);
      }
    }
    return level;
  }

private:
  void helper(TreeNode *root, unordered_map<int, int> *m, int level) {
    if (root == nullptr)
      return;

    auto it = m->find(level);
    if (it != m->end()) {
      it->second = it->second + root->val;
    } else {
      m->insert(make_pair(level, root->val));
    }
    helper(root->left, m, level + 1);
    helper(root->right, m, level + 1);
  }
};

int main(int argc, char *argv[]) {
  TreeNode *root = new TreeNode(
      1, new TreeNode(7, new TreeNode(7), new TreeNode(8)), new TreeNode(0));
  Solution solution = Solution();

  cout << solution.maxLevelSum(root) << endl;
}
