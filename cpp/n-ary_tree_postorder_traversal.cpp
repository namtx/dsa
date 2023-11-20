#include <vector>

using namespace std;

class Node {
public:
  int val;
  vector<Node *> children;

  Node() {}

  Node(int _val) { val = _val; }

  Node(int _val, vector<Node *> _children) {
    val = _val;
    children = _children;
  }
};

class Solution {
public:
  vector<int> postorder(Node *root) {
    if (root == nullptr)
      return vector<int>{};
    vector<int> r;
    for (auto children : root->children) {
      vector<int> childrenPostorder = postorder(children);
      r.insert(r.end(), childrenPostorder.begin(), childrenPostorder.end());
    }
    r.push_back(root->val);
    return r;
  }
};
