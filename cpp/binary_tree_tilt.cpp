#include <array>
#include <iostream>

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

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
  int ans = 0;

public:
  int findTilt(TreeNode *root) {
    helper(root);
    return ans;
  }

private:
  // this function return an 2-elements array [total, tilt]
  array<int, 2> helper(TreeNode *root) {
    if (root == nullptr) {
      return array<int, 2>{{0, 0}};
    }
    array<int, 2> l = helper(root->left);
    /* cout << "l[" << l[0] << "," << l[1] << "]" << endl; */
    array<int, 2> r = helper(root->right);
    /* cout << "r[" << r[0] << "," << r[1] << "]" << endl; */

    int tilt = abs(l[0] - r[0]);
    ans += tilt;

    return array<int, 2>{{l[0] + r[0] + root->val, tilt}};
  }
};

int main(int argc, char *argv[]) {
  TreeNode *root =
      new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)),
                   new TreeNode(9, nullptr, new TreeNode(7)));
  cout << (new Solution())->findTilt(root);

  return 0;
}
