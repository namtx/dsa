// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree


#include <iostream>
#include <vector>

using namespace std;

static auto _ = [](){
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
    int pseudoPalindromicPaths (TreeNode* root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode* root, int path) {
        if (root == nullptr) {
            return 0;
        }
        path ^= (1 << root->val);
        if (root->left == nullptr && root->right == nullptr) {
            return (path & (path-1)) == 0 ? 1: 0;
        } else {
            return dfs(root->left, path) + dfs(root->right, path);
        }
    }
};
